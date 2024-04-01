package com.ms.android.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.android.dto.HistoryAddDto;
import com.ms.android.dto.HistoryDto;
import com.ms.android.dto.ScheduleDto;
import com.ms.android.entity.History;
import com.ms.android.repository.HistoryRepository;
import com.ms.android.repository.ScheduleRepository;
import com.ms.android.service.HistoryService;
import com.ms.android.service.ScheduleService;
@Service
public class HistoryServiceImpl implements HistoryService{
	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private ScheduleService scheduleService;
	public HistoryDto toDto(History history) {
		ScheduleDto scheduleDto = scheduleService.toDto(history.getSchedule());
		return HistoryDto.builder().id(history.getId())
				.moisture(scheduleDto.getMoisture())
				.time(history.getTime())
				.build();
	}
	@Override
	public List<HistoryDto> getAll() {
		// TODO Auto-generated method stub
		List<HistoryDto> list = new ArrayList<>();
		historyRepository.findAll().stream().forEach((item) -> list.add(toDto(item)));
		return list;
	}

	@Override
	public History get(int id) {
		// TODO Auto-generated method stub
		return historyRepository.findById(id).get();
	}

	@Override
	public History save(HistoryAddDto historyAddDto) {
		// TODO Auto-generated method stub
		History history = History.builder().time(historyAddDto.getTime())
				.schedule(scheduleRepository.findById(historyAddDto.getSchedule_id()).get())
				.build();
				
		return historyRepository.save(history);
	}
	public int compareLocalDateTime(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
		if (localDateTime.getYear() == localDateTime2.getYear()) {
			if (localDateTime.getMonthValue() == localDateTime2.getMonthValue()) {
				return localDateTime.getDayOfMonth() - localDateTime2.getDayOfMonth();
 			}
			return localDateTime.getMonthValue() - localDateTime2.getMonthValue();
		}
		return localDateTime.getYear() - localDateTime2.getYear();
	}
	@Override
	public List<HistoryDto> find(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
		// TODO Auto-generated method stub
		List<HistoryDto> list = new ArrayList<>();
		List<History> histories = historyRepository.findAll();
		histories.stream().filter((item) -> compareLocalDateTime(item.getTime(), fromDateTime) >= 0 
				&& compareLocalDateTime(item.getTime(), toDateTime) <= 0).collect(Collectors.toList())
				.forEach((item) -> list.add(toDto(item)));
		return list;	
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		historyRepository.deleteById(id);
	}
	@Override
	public List<HistoryDto> getRecentHistories() {
		// TODO Auto-generated method stub
		List<HistoryDto> historyDtos = getAll();
		historyDtos.sort(new Comparator<HistoryDto>() {
			@Override
			public int compare(HistoryDto o1, HistoryDto o2) {
				// TODO Auto-generated method stub
				return o2.getTime().compareTo(o1.getTime());
			}
		});
		List<HistoryDto> ans = new ArrayList<>();
		for (int i = 0; i < historyDtos.size() && i < 7; i++) {
			ans.add(historyDtos.get(i));
			
		}
		ans.sort(new Comparator<HistoryDto>() {
			@Override
			public int compare(HistoryDto o1, HistoryDto o2) {
				// TODO Auto-generated method stub
				return o1.getTime().compareTo(o2.getTime());
			}
		});
		return ans;
	}
	
}
