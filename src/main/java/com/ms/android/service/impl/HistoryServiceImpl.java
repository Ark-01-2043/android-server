package com.ms.android.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.android.entity.History;
import com.ms.android.repository.HistoryRepository;
import com.ms.android.service.HistoryService;
@Service
public class HistoryServiceImpl implements HistoryService{
	@Autowired
	private HistoryRepository historyRepository;
	@Override
	public List<History> getAll() {
		// TODO Auto-generated method stub
		return historyRepository.findAll();
	}

	@Override
	public History get(int id) {
		// TODO Auto-generated method stub
		return historyRepository.findById(id).get();
	}

	@Override
	public History save(History history) {
		// TODO Auto-generated method stub
		return historyRepository.save(history);
	}
	public int compareLocalDateTime(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
		if (localDateTime.getHour() == localDateTime2.getHour()) {
			return localDateTime.getMinute() - localDateTime2.getMinute();
		}
		return localDateTime.getHour() - localDateTime2.getHour();
	}
	@Override
	public List<History> find(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
		// TODO Auto-generated method stub
		List<History> histories = historyRepository.findAll();
		return histories.stream().filter((item) -> compareLocalDateTime(item.getTime(), fromDateTime) >= 0 
				&& compareLocalDateTime(item.getTime(), toDateTime) <= 0).collect(Collectors.toList());
			
	}
	
}
