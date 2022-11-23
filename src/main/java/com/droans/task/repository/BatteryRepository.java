package com.droans.task.repository;

import com.droans.task.domain.BatteryLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryLog, Long> {
}
