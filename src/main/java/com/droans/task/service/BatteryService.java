package com.droans.task.service;

import com.droans.task.domain.BatteryLog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public interface BatteryService {

    BatteryLog save(BatteryLog batteryLog);


    BatteryLog update(BatteryLog batteryLog);


    Page<BatteryLog> findAll(Pageable pageable);

    Optional<BatteryLog> findOne(Long id);




    void delete(Long id);
}
