package com.ms.android.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.android.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	List<Schedule> findByTimeGreaterThanEqualAndAndLessThanEqual(LocalDateTime fromDateTime, LocalDateTime toDateTime);
}
