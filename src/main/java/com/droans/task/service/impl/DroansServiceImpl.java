package com.droans.task.service.impl;

import com.droans.task.domain.Drons;
import com.droans.task.repository.DonsRepository;
import com.droans.task.service.DroansService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DroansServiceImpl implements DroansService {

    private static final int MAX_DROAN = 10;
    private final DonsRepository donsRepository;

    public DroansServiceImpl(DonsRepository donsRepository) {
        this.donsRepository = donsRepository;
    }


    @Override
    public Drons save(Drons droan) {
        List<Drons> lists =  donsRepository.findAll();
        if(lists.size() < MAX_DROAN){
            return donsRepository.save(droan);
        }else {
            return  droan;
        }

    }

    @Override
    public Drons update(Drons droan) {
        return donsRepository.save(droan);
    }

    @Override
    public Optional<Drons> partialUpdate(Drons drons)
    {
        return donsRepository
                .findById(drons.getId())
                .map(existingAppUsers -> {
                    if (drons.getModel() != null) {
                        existingAppUsers.setModel(drons.getModel());
                    }



                    if (drons.getBatteryCapacity() != -1) {
                        existingAppUsers.setBatteryCapacity(drons.getBatteryCapacity());
                    }
                    if (drons.getWeightlimit() != -1) {
                        existingAppUsers.setweightLimit(drons.getWeightlimit());
                    }
                    if (drons.getState() != null) {
                        existingAppUsers.setState(drons.getState());
                    }

                    if (drons.getBatteryCapacity() != -1) {
                        existingAppUsers.setBatteryCapacity(drons.getBatteryCapacity());
                    }

                    if (drons.getSerial() != 0) {
                        existingAppUsers.setSerial(drons.getSerial());
                    }

                    return existingAppUsers;
                })
                .map(donsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Drons> findAll(Pageable p)
    {
        return donsRepository.findAll(p);
    }

    @Override
    public Optional<Drons> findOne(Long id) {
        return donsRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        donsRepository.deleteById(id);
    }

    @Override
    public Page<Drons> findAllByStatus( String status , Pageable pageable) {
        return donsRepository.findAllByStatus(status , pageable);
    }
}
