package com.droans.task.service.impl;

import com.droans.task.domain.Medication;
import com.droans.task.repository.MedicationRepository;
import com.droans.task.service.MedicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;

    public MedicationServiceImpl(MedicationRepository donsRepository) {
        this.medicationRepository = donsRepository;
    }

    @Override
    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public Medication update(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public Optional<Medication> partialUpdate(Medication medication) {
        return medicationRepository
                .findById(medication.getId())
                .map(existingAppUsers -> {



                    if (medication.getCode()!= null) {
                        existingAppUsers.setCode(medication.getCode());
                    }



                    if (medication.getImage()!= null) {
                        existingAppUsers.setImage(medication.getImage());
                    }
                    if (medication.getName()!= null) {
                        existingAppUsers.setName(medication.getName());
                    }





                    return existingAppUsers;
                })
                .map(medicationRepository::save);
    }

    @Override
    public Page<Medication> findAll(Pageable p) {
        return medicationRepository.findAll(p);
    }

    @Override
    public Optional<Medication> findOne(Long id) {
        return medicationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        medicationRepository.deleteById(id);
    }
}
