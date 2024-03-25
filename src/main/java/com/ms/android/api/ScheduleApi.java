package com.ms.android.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import com.ms.android.dto.ScheduleDto;
import com.ms.android.dto.ScheduleSearchDto;
import com.ms.android.entity.Schedule;
import com.ms.android.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin
public class ScheduleApi {
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(scheduleService.getAll());
		
	}
	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody ScheduleSearchDto scheduleSearchDto){
		return ResponseEntity.ok(scheduleService.find(scheduleSearchDto.getFromDate(), scheduleSearchDto.getToDate()));
	}
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Schedule schedule){
		
		return ResponseEntity.ok(scheduleService.save(schedule));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(scheduleService.delete(id));
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> patch(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(scheduleService.active(id));
	}
}
