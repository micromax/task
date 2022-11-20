package com.droans.task.service;

import com.droans.task.domain.Drons;
import com.droans.task.domain.Medication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MedicationService {



    Medication save(Medication medication);


    Medication update(Medication medication);

    Optional<Medication> partialUpdate(Medication medication);

    Page<Medication> findAll(Pageable pageable);

    Optional<Medication> findOne(Long id);

    void delete(Long id);
}
