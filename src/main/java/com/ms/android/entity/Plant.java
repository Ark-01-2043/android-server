package com.ms.android.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ten_cay;
	private String image;
	private float minIdealTemp;
	private float maxIdealTemp;
	private float minIdealHumidity;
	private float maxIdealHumidity;
	private float minIdealSunlight;
	private float maxIdealSunlight;
	private float minIdealSoilMoisture;
	private float maxIdealSoilMoisture;
	
}
