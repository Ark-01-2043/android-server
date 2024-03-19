package com.ms.android.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.android.entity.Plant;
import java.util.List;


@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{
	List<Plant> findByTen_cayContaining(String ten_cay);
	
}
