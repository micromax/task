package com.droans.task.repository;


import com.droans.task.domain.Drons;
import com.droans.task.domain.Transactions;
import com.droans.task.domain.enumModels.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {



    @Query(value ="select Transactions from Transactions Transactions WHERE Transactions.DronsId =:drone ORDER BY Transactions.id DESC" )
    Transactions FindLastActiveTransaction(@Param("drone") Drons drone);

}
