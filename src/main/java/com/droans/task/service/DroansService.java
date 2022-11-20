package com.droans.task.service;

import com.droans.task.domain.Drons;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DroansService {


    Drons save(Drons droan);


    Drons update(Drons droan);
    Optional<Drons> partialUpdate(Drons droan);

    Page<Drons> findAll(Pageable pageable);

    Optional<Drons> findOne(Long id);

    void delete(Long id);

}
