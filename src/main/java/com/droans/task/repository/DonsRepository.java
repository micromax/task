package com.droans.task.repository;

import com.droans.task.domain.Drons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonsRepository extends JpaRepository<Drons, Long> {
}