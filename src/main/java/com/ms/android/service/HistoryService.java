package com.ms.android.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ms.android.entity.History;

public interface HistoryService {
	public List<History> getAll();
	public History get(int id);
	public History save(History history);
	public List<History> find(LocalDateTime fromDateTime, LocalDateTime toDateTime);
}
