package com.ms.android.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ms.android.entity.Schedule;
import com.ms.android.repository.ScheduleRepository;
import com.ms.android.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Override
	public List<Schedule> getAll() {
		// TODO Auto-generated method stub
		return scheduleRepository.findAll();
	}

	@Override
	public List<Schedule> find(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByTimeGreaterThanEqualAndAndLessThanEqual(fromDateTime, toDateTime);
	}

	@Override
	public Schedule save(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleRepository.save(schedule);
	}

}
