package com.droans.task.service.impl;
import com.droans.task.domain.BatteryLog;

import com.droans.task.repository.BatteryRepository;
import com.droans.task.service.BatteryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@Transactional
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;


    public BatteryServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }


    @Override
    public BatteryLog save(BatteryLog batteryLog) {
      if(batteryLog.getId() == null){
          return batteryRepository.save(batteryLog);
      }else {
          return null;
      }


    }

    @Override
    public BatteryLog update(BatteryLog batteryLog) {
        return batteryRepository.save(batteryLog);
    }



    @Override
    public Page<BatteryLog> findAll(Pageable pageable) {
        return batteryRepository.findAll(pageable);
    }

    @Override
    public Optional<BatteryLog> findOne(Long id) {
        return batteryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        batteryRepository.deleteById(id);
    }
}
