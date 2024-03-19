package com.ms.android.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.android.entity.Plant;
import com.ms.android.repository.PlantRepository;
import com.ms.android.service.PlantService;

@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantRepository plantRepository;
	@Override
	public List<Plant> getAll() {
		// TODO Auto-generated method stub
		return plantRepository.findAll();
	}

	@Override
	public List<Plant> find(String keyword) {
		// TODO Auto-generated method stub
		return plantRepository.findByTen_cayContaining(keyword);
	}

	@Override
	public Plant get(int id) {
		// TODO Auto-generated method stub
		return plantRepository.findById(id).get();
	}

	@Override
	public Plant save(Plant plant) {
		// TODO Auto-generated method stub
		return plantRepository.save(plant);
	}
	
}
