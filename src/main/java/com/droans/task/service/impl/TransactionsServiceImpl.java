package com.droans.task.service.impl;

import com.droans.task.domain.Transactions;
import com.droans.task.repository.TransactionsRepository;
import com.droans.task.service.TransactionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }



    @Override
    public Transactions save(Transactions transactions) {
        if(transactions.getId() == null)
        {
          return   transactionsRepository.save(transactions);
        }else {
            return null;
        }
    }

    @Override
    public Transactions update(Transactions transactions) {
       return transactionsRepository.save(transactions);
    }

    @Override
    public Page<Transactions> findAll(Pageable pageable) {
        return transactionsRepository.findAll(pageable);
    }

    @Override
    public Optional<Transactions> findOne(Long id) {
        return transactionsRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        transactionsRepository.deleteById(id);
    }
}
