package com.droans.task.rest;

import com.droans.task.domain.Drons;
import com.droans.task.domain.Medication;
import com.droans.task.domain.Transactions;
import com.droans.task.domain.enumModels.State;
import com.droans.task.repository.DonsRepository;
import com.droans.task.repository.MedicationRepository;
import com.droans.task.repository.TransactionsRepository;
import com.droans.task.service.DroansService;
import com.droans.task.service.MedicationService;
import com.droans.task.service.TransactionsService;
import com.droans.task.service.dto.DroneLoadInforamtionsDTO;
import com.droans.task.service.dto.DronsBatteryLevelDTO;
import com.droans.task.service.dto.LoadDroneDTO;
import com.droans.task.service.dto.TransactionsMsgDTO;
import com.droans.task.utile.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DronasController {

    private  final DroansService droansService;
    private final DonsRepository donsRepository;

    private  final MedicationService medicationService;
    private final MedicationRepository medicationRepository;



    private final TransactionsService transactionsService;
    private final TransactionsRepository transactionsRepository;


    public DronasController(DroansService droansService, DonsRepository donsRepository, MedicationService medicationService, MedicationRepository medicationRepository, TransactionsService transactionsService, TransactionsRepository transactionsRepository) {
        this.droansService = droansService;
        this.donsRepository = donsRepository;
        this.medicationService = medicationService;
        this.medicationRepository = medicationRepository;
        this.transactionsService = transactionsService;
        this.transactionsRepository = transactionsRepository;
    }


    @Transactional
    @PostMapping("/drones-load")
    public ResponseEntity<TransactionsMsgDTO> load(@RequestBody LoadDroneDTO loadDroneDTO){
        TransactionsMsgDTO transactionsMsgDTO = new TransactionsMsgDTO();
        if(loadDroneDTO.getDrone_id() != null && loadDroneDTO.getMedication_id() != null)
        {


            Optional<Medication> medication = medicationService.findOne(loadDroneDTO.getMedication_id());
            Optional<Drons> drones = droansService.findOne(loadDroneDTO.getDrone_id());

            if(medication.isPresent() && drones.isPresent())
            {

                if(medication.get().getWeight() <= drones.get().getWeightlimit()
                && drones.get().getBatteryCapacity() >= 25 && drones.get().getState() == State.IDLE

                ){


                    Transactions transactions = new Transactions();

                    transactions.setDronsId(drones.get());
                    transactions.setMedicationId(medication.get());
                    transactions.setState(State.LOADED);

                    transactionsService.save(transactions);

                    drones.get().setState(State.LOADED);
                    droansService.update(drones.get());

                    transactionsMsgDTO.setError(false);
                    transactionsMsgDTO.setMassage("transaction done successfully");
                    transactionsMsgDTO.setSuccess(true);

                }else {
                    transactionsMsgDTO.setError(true);
                    transactionsMsgDTO.setMassage("Unable to load this drone");
                    transactionsMsgDTO.setSuccess(false);
                }
            }else
            {
                transactionsMsgDTO.setError(true);
                transactionsMsgDTO.setMassage("Object not found");
                transactionsMsgDTO.setSuccess(false);
            }

        }else {
            transactionsMsgDTO.setError(true);
            transactionsMsgDTO.setMassage("Object not found");
            transactionsMsgDTO.setSuccess(false);
        }



        return ResponseEntity.ok().body(transactionsMsgDTO);
    }
    @PostMapping("/drones")
    public ResponseEntity<Drons> create(@RequestBody Drons drons) throws URISyntaxException {


        System.out.println(drons.toString());
        if (drons.getId() != null) {
            throw new RuntimeException("Error massage");
        }
        Drons result = droansService.save(drons);
        return ResponseEntity
                .created(new URI("/api/app-users/" + result.getId()))

                .body(result);
    }


    @GetMapping("/drones")
    public ResponseEntity<List<Drons>> getAll(@RequestParam(name = "page" ,  required = false) String pageNum ) {


        if(pageNum == null)
        {
            pageNum = "0";
        }

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Drons> page = droansService.findAll(pageable);

        return ResponseEntity.ok().body(page.getContent());
    }



    @GetMapping("/drone-available")
    public ResponseEntity<List<Drons>> getAllAvailable(@RequestParam(name = "page", required = false) String pageNum) {



        if(pageNum == null)
        {
            pageNum = "0";
        }

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum), 10);


        Page<Drons> page = droansService.findAllByStatus(State.IDLE,pageable);

        return ResponseEntity.ok().body(page.getContent());
    }



    @GetMapping("/drone/{id}")
    public ResponseEntity<Drons> getDroan(@PathVariable Long id) {

        Optional<Drons> dron = droansService.findOne(id);

        return ResponseUtil.wrapOrNotFound(dron);
    }



    @GetMapping("/drone-load-info/{id}")
    public ResponseEntity<DroneLoadInforamtionsDTO> getDroneLoadInformation(@PathVariable Long id) {

        Optional<Drons> d = droansService.findOne(id);
        DroneLoadInforamtionsDTO droneLoadInforamtionsDTO = new DroneLoadInforamtionsDTO();
        if(d.isPresent()){


            droneLoadInforamtionsDTO.setId(d.get().getId());
            droneLoadInforamtionsDTO.setState(d.get().getState());
            droneLoadInforamtionsDTO.setModel( d.get().getModel()) ;
            droneLoadInforamtionsDTO.setSerial(d.get().getSerial());
            droneLoadInforamtionsDTO.setBatteryCapacity(d.get().getBatteryCapacity()) ;
            droneLoadInforamtionsDTO.setWeightlimit(d.get().getWeightlimit()) ;


            if(d.get().getState() != State.IDLE)
            {
                Transactions t =    transactionsRepository.FindLastActiveTransaction(d.get());
                if(t != null){
                    droneLoadInforamtionsDTO.setTransactions(t);
                }

            }
        }


        return  ResponseEntity.ok().body(droneLoadInforamtionsDTO);
    }

    @GetMapping("/drone-battery/{id}")
    public ResponseEntity<DronsBatteryLevelDTO> checkBattery(@PathVariable Long id){
        Optional<Drons> drone = droansService.findOne(id);
        Optional<DronsBatteryLevelDTO> dronsBatteryLevelDTO = Optional.of(new DronsBatteryLevelDTO());
        if(drone.isPresent())
        {
            dronsBatteryLevelDTO = Optional.of(new DronsBatteryLevelDTO(drone.get()));
            return ResponseUtil.wrapOrNotFound(dronsBatteryLevelDTO);
        }else {
            return ResponseUtil.wrapOrNotFound(dronsBatteryLevelDTO);
        }

    }


    @DeleteMapping("/drone/{id}")
    public ResponseEntity<Void> deleteDroan(@PathVariable Long id) {

        droansService.delete(id);
        return ResponseEntity
              .noContent()
              .build();
    }
}
