package com.droans.task.repository;

import com.droans.task.domain.Drons;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonsRepository extends JpaRepository<Drons, Long> {


    @Query(
            value ="select Drons from Drons Drons WHERE  Drons.state =:status",
            countQuery = "select Drons from Drons Drons WHERE  Drons.state =:status"
    )
    Page<Drons> findAllByStatus(@Param("status") String status, Pageable pageable);


}
