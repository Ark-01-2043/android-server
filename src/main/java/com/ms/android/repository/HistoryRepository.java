package com.ms.android.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.android.entity.History;

public interface HistoryRepository extends JpaRepository<History, Integer> {
	
}
