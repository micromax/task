package com.droans.task.service;

import com.droans.task.domain.Drons;
import com.droans.task.domain.enumModels.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public interface DroansService {


    Drons save(Drons droan);


    Drons update(Drons droan);
    Optional<Drons> partialUpdate(Drons droan);

    Page<Drons> findAll(Pageable pageable);

    Optional<Drons> findOne(Long id);




    void delete(Long id);

    Page<Drons> findAllByStatus(   State state , Pageable pageable);

    List<Drons> findAllByStatusNotMatch(   State state );


}
