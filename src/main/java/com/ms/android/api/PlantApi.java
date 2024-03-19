package com.ms.android.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.android.entity.Plant;
import com.ms.android.service.PlantService;

@RequestMapping("/plant")
@RestController
public class PlantApi {
	@Autowired
	private PlantService plantService;
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(plantService.getAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable int id){
		return ResponseEntity.ok(plantService.get(id));
	}
	@GetMapping
	public ResponseEntity<?> find(@RequestParam(name = "keyword") String keyword){
		return ResponseEntity.ok(plantService.find(keyword));
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Plant plant){
		return ResponseEntity.ok(plantService.save(plant));
	}
}
