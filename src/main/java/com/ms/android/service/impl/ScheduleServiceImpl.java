package com.ms.android.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.dialect.function.NvlCoalesceEmulation;
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
		List<Schedule> list = new ArrayList<>();
		List<Schedule> schedules = scheduleRepository.findAll();
		for (Schedule schedule : schedules) {
			if (compareLocalDateTime(schedule.getTime(), fromDateTime) >= 0 && compareLocalDateTime(schedule.getTime(), toDateTime) <= 0) {
				list.add(schedule);
			}
		}
		return list;
	}

	@Override
	public Schedule save(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleRepository.save(schedule);
	}
	public int compareLocalDateTime(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
		if (localDateTime.getHour() == localDateTime2.getHour()) {
			return localDateTime.getMinute() - localDateTime2.getMinute();
		}
		return localDateTime.getHour() - localDateTime2.getHour();
	}
	@Override
	public boolean check(Schedule schedule) {
		// TODO Auto-generated method stub
		List<Schedule> schedules = scheduleRepository.findAll();
		for (Schedule schedule2 : schedules) {
			if (compareLocalDateTime(schedule.getTime(), schedule2.getTime()) == 0) {
				return false;
			}
		}
		return true;
	}
	

}
