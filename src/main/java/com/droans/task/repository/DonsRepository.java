package com.droans.task.repository;

import com.droans.task.domain.Drons;
import com.droans.task.domain.enumModels.State;
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
            value ="select Drons from Drons Drons WHERE  Drons.state =:state",
            countQuery = "select Drons from Drons Drons WHERE  Drons.state =:state"
    )
    Page<Drons> findAllByStatus(@Param("state") State state, Pageable pageable);

    @Query(
            value ="select Drons from Drons Drons WHERE  Drons.state !=:state",
            countQuery = "select Drons from Drons Drons WHERE  Drons.state !=:state"
    )
    Page<Drons> findAllByStatusNotMatch(@Param("state") State state, Pageable pageable);


}
