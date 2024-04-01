package com.ms.android.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ms.android.dto.HistoryAddDto;
import com.ms.android.dto.HistoryDto;
import com.ms.android.entity.History;

public interface HistoryService {
	public HistoryDto toDto(History history);
	public List<HistoryDto> getAll();
	public History get(int id);
	public History save(HistoryAddDto historyAddDto);
	public void delete(int id);
	public List<HistoryDto> find(LocalDateTime fromDateTime, LocalDateTime toDateTime);
	public List<HistoryDto> getRecentHistories();
}
