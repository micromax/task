package com.droans.task.service;


import com.droans.task.domain.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public interface TransactionsService {


    Transactions save(Transactions transactions);


    Transactions update(Transactions transactions);



    Page<Transactions> findAll(Pageable pageable);

    Optional<Transactions> findOne(Long id);

    void delete(Long id);
}
