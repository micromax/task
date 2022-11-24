package com.droans.task.config;

import com.droans.task.domain.BatteryLog;
import com.droans.task.domain.Drons;
import com.droans.task.domain.Medication;
import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;
import com.droans.task.service.BatteryService;
import com.droans.task.service.DroansService;
import com.droans.task.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Configuration
@EnableScheduling
public class SpringConfig {


   @Autowired
    DroansService droansService;


    @Autowired
    BatteryService batteryService;


    @Autowired
    MedicationService medicationService;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedDronesTable();
        seedMedicationTable();
    }

    private void seedDronesTable() {

        Drons drone1 = new Drons();
        drone1.setBatteryCapacity(100);
        drone1.setState(State.IDLE);
        drone1.setSerial(1000001);
        drone1.setWeightlimit(500);
        drone1.setModel(Model.Lightweight);
        droansService.save(drone1);

        Drons drone2 = new Drons();
        drone2.setBatteryCapacity(100);
        drone2.setState(State.IDLE);
        drone2.setSerial(1000002);
        drone2.setWeightlimit(200);
        drone2.setModel(Model.Heavyweight);
        droansService.save(drone2);



    }
    private void seedMedicationTable() {

        Medication medication = new Medication();
        medication.setName("MED 1");
        medication.setImage("path/file");
        medication.setWeight(100);
        medication.setCode("TM-1");
        medicationService.save(medication);

    }

    @Transactional
    @Scheduled(fixedRate = 10000 , initialDelay = 20000)
    public void scheduleFixedDelayTask() {

        List<Drons> NoneIdelDroans = droansService.findAllByStatusNotMatch(State.IDLE);

        if(NoneIdelDroans.size() != 0)
        {

            for (Drons d:
                    NoneIdelDroans) {
                if(d.getBatteryCapacity() != 0)
                {
                    int nBatteryCapacity = d.getBatteryCapacity() - 1;
                    d.setBatteryCapacity(nBatteryCapacity);
                    droansService.update(d);
                   // System.out.println(d.toString());
                    BatteryLog batteryLog = new BatteryLog();
                    batteryLog.setCapacity(nBatteryCapacity);
                    batteryLog.setDronsId(d);
                    batteryLog.setCreatedDate(Instant.now());
                    batteryLog.setLastModifiedDate(Instant.now());
                    batteryService.save(batteryLog);

                }


            }







        }

    }
}
