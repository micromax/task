package com.droans.task.service.impl;

import com.droans.task.domain.Drons;
import com.droans.task.repository.DonsRepository;
import com.droans.task.service.DroansService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
@Transactional
public class DroansServiceImpl implements DroansService {

    private final DonsRepository donsRepository;

    public DroansServiceImpl(DonsRepository donsRepository) {
        this.donsRepository = donsRepository;
    }


    @Override
    public Drons save(Drons droan) {
        return donsRepository.save(droan);
    }

    @Override
    public Drons update(Drons droan) {
        return null;
    }

    @Override
    public Page<Drons> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Drons> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
