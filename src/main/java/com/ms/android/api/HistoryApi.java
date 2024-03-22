package com.ms.android.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.android.entity.History;
import com.ms.android.service.HistoryService;

@Service
public class HistoryApi {
	@Autowired
	private HistoryService historyService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(historyService.getAll());
	}
	@PostMapping
	public ResponseEntity<?> add(@RequestBody History history){
		return ResponseEntity.ok(historyService.save(history));
	}
	
	
}
