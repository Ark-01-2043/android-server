package com.ms.android.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.android.entity.Schedule;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
//	List<Schedule> findByTimeGreaterThanEqualAndAndLessThanEqual(LocalDateTime fromDateTime, LocalDateTime toDateTime);
	List<Schedule> findByDeleted(boolean deleted);
}
