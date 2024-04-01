package com.ms.android.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.android.dto.HistoryAddDto;
import com.ms.android.dto.ScheduleSearchDto;
import com.ms.android.entity.History;
import com.ms.android.service.HistoryService;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryApi {
	@Autowired
	private HistoryService historyService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(historyService.getAll());
	}
	@PostMapping
	public ResponseEntity<?> add(@RequestBody HistoryAddDto historyAddDto){
		return ResponseEntity.ok(historyService.save(historyAddDto));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") int id){
		historyService.delete(id);
		return ResponseEntity.ok("Xóa thành công");
	}
	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody ScheduleSearchDto scheduleSearchDto){
		return ResponseEntity.ok(historyService.find(scheduleSearchDto.getFromDate(), scheduleSearchDto.getToDate()));
	}
	@GetMapping("/chart")
	public ResponseEntity<?> top7(){
		return ResponseEntity.ok(historyService.getRecentHistories());
	}
}
