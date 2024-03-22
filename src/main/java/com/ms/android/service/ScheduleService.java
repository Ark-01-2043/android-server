package com.ms.android.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ms.android.entity.Schedule;

public interface ScheduleService {
	
	public List<Schedule> getAll();
	public List<Schedule> find(LocalDateTime fromDateTime, LocalDateTime toDateTime);
	public Schedule save(Schedule schedule);
	public boolean check(Schedule schedule);
}
