package com.ms.android.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.android.entity.Schedule;
import com.ms.android.repository.ScheduleRepository;
import com.ms.android.service.ScheduleService;
@Service
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
//		return scheduleRepository.findByTimeGreaterThanEqualAndAndLessThanEqual(fromDateTime, toDateTime);
		return null;
	}

	@Override
	public Schedule save(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleRepository.save(schedule);
	}

}
