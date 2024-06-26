package com.ms.android.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.dialect.function.NvlCoalesceEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.android.dto.ScheduleDto;
import com.ms.android.entity.Plant;
import com.ms.android.entity.Schedule;
import com.ms.android.exception.ResourceExistedException;
import com.ms.android.repository.PlantRepository;
import com.ms.android.repository.ScheduleRepository;
import com.ms.android.service.ScheduleService;
@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private PlantRepository plantRepository;
	public boolean isExisted(Schedule schedule) {
		boolean isExisted = false;
		List<Schedule> schedules = scheduleRepository.findAll();
		return schedules.stream().filter((item) -> 
			item.getTime().getHour() == schedule.getTime().getHour() && item.getTime().getMinute() == schedule.getTime().getMinute() && item.getId() != schedule.getId()			
		).collect(Collectors.toList()).size() > 0;
		
	}
	@Override
	public ScheduleDto toDto(Schedule schedule) {
		Plant plant = null;
		if (schedule.isAuto()) {
			plant =plantRepository.findById(schedule.getPlantId()).get();
		}
		return ScheduleDto.builder().id(schedule.getId())
				.moisture(schedule.isAuto()?  (int)plant.getMinIdealSoilMoisture()+"%-"+(int)plant.getMaxIdealSoilMoisture()+"%" : schedule.getMoisture()+"%")
				.isActive(schedule.isActived())
				.isDeleted(schedule.isDeleted())
				.repeat(schedule.getRepeat())
				.time(schedule.getTime())
				.auto(schedule.isAuto())
				.nextTime(schedule.getNextTime())
				.build();
	}
	@Override
	public List<ScheduleDto> getAll() {
		// TODO Auto-generated method stub
		List<ScheduleDto> list = new ArrayList<>();
		scheduleRepository.findByDeleted(false).stream().forEach((item) -> {list.add(toDto(item)); System.out.println(item.getId());});
		return list;
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
	public Schedule save(Schedule schedule) throws ResourceExistedException {
		// TODO Auto-generated method stub
		if(isExisted(schedule)) {
			throw new ResourceExistedException("Lịch tưới đã tồn tại");
		}
		LocalDateTime localDateTime = LocalDate.now().atTime(schedule.getTime().toLocalTime());
		LocalDateTime nowDateTime = LocalDateTime.now();
		if (nowDateTime.isAfter(localDateTime)) {
			localDateTime = localDateTime.plusDays(1);
		}
		schedule.setNextTime(localDateTime);
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
			if (compareLocalDateTime(schedule.getTime(), schedule2.getTime()) == 0 && schedule.getId() != schedule2.getId()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Schedule get(int id) {
		// TODO Auto-generated method stub
		return scheduleRepository.findById(id).get();
	}

	@Override
	public Schedule delete(int id) {
		// TODO Auto-generated method stub
		Schedule schedule = scheduleRepository.findById(id).get();
		schedule.setDeleted(true);
		scheduleRepository.save(schedule);
		return schedule;
	}
	@Override
	public Schedule active(int id) {
		// TODO Auto-generated method stub
		Schedule schedule = scheduleRepository.findById(id).get();
		schedule.setActived(!schedule.isActived());
		if (schedule.isActived()) {
			LocalDateTime localDateTime = LocalDate.now().atTime(schedule.getTime().toLocalTime());
			LocalDateTime nowDateTime = LocalDateTime.now();
			if (nowDateTime.isAfter(localDateTime)) {
				localDateTime = localDateTime.plusDays(1);
			}
			schedule.setNextTime(localDateTime);
		}
		scheduleRepository.save(schedule);
		return schedule;
	}
	@Override
	public List<LocalDateTime> getUpcomingSchedule() {
		// TODO Auto-generated method stub
		List<Schedule> schedules = scheduleRepository.findByDeleted(false);
		
		return schedules.stream().map((item) -> {
			LocalDateTime localDateTime = LocalDate.now().atTime(item.getTime().toLocalTime());
			LocalDateTime nowDateTime = LocalDateTime.now();
			if (nowDateTime.isAfter(localDateTime)) {
				return localDateTime.plusDays(1);
			}
			return localDateTime;
		}).toList();
	}
	

}
