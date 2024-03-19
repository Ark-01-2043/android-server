package com.ms.android.service;

import java.util.List;

import com.ms.android.entity.Plant;

public interface PlantService {
	public List<Plant> getAll();
	public List<Plant> find(String keyword);
	public Plant get(int id);
	public Plant save(Plant plant);
}
