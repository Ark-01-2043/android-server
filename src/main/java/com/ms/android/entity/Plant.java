package com.ms.android.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen_cay() {
		return ten_cay;
	}
	public void setTen_cay(String ten_cay) {
		this.ten_cay = ten_cay;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getMinIdealTemp() {
		return minIdealTemp;
	}
	public void setMinIdealTemp(float minIdealTemp) {
		this.minIdealTemp = minIdealTemp;
	}
	public float getMaxIdealTemp() {
		return maxIdealTemp;
	}
	public void setMaxIdealTemp(float maxIdealTemp) {
		this.maxIdealTemp = maxIdealTemp;
	}
	public float getMinIdealHumidity() {
		return minIdealHumidity;
	}
	public void setMinIdealHumidity(float minIdealHumidity) {
		this.minIdealHumidity = minIdealHumidity;
	}
	public float getMaxIdealHumidity() {
		return maxIdealHumidity;
	}
	public void setMaxIdealHumidity(float maxIdealHumidity) {
		this.maxIdealHumidity = maxIdealHumidity;
	}
	public float getMinIdealSunlight() {
		return minIdealSunlight;
	}
	public void setMinIdealSunlight(float minIdealSunlight) {
		this.minIdealSunlight = minIdealSunlight;
	}
	public float getMaxIdealSunlight() {
		return maxIdealSunlight;
	}
	public void setMaxIdealSunlight(float maxIdealSunlight) {
		this.maxIdealSunlight = maxIdealSunlight;
	}
	public float getMinIdealSoilMoisture() {
		return minIdealSoilMoisture;
	}
	public void setMinIdealSoilMoisture(float minIdealSoilMoisture) {
		this.minIdealSoilMoisture = minIdealSoilMoisture;
	}
	public float getMaxIdealSoilMoisture() {
		return maxIdealSoilMoisture;
	}
	public void setMaxIdealSoilMoisture(float maxIdealSoilMoisture) {
		this.maxIdealSoilMoisture = maxIdealSoilMoisture;
	}
	public Plant(Integer id, String ten_cay, String image, float minIdealTemp, float maxIdealTemp,
			float minIdealHumidity, float maxIdealHumidity, float minIdealSunlight, float maxIdealSunlight,
			float minIdealSoilMoisture, float maxIdealSoilMoisture) {
		super();
		this.id = id;
		this.ten_cay = ten_cay;
		this.image = image;
		this.minIdealTemp = minIdealTemp;
		this.maxIdealTemp = maxIdealTemp;
		this.minIdealHumidity = minIdealHumidity;
		this.maxIdealHumidity = maxIdealHumidity;
		this.minIdealSunlight = minIdealSunlight;
		this.maxIdealSunlight = maxIdealSunlight;
		this.minIdealSoilMoisture = minIdealSoilMoisture;
		this.maxIdealSoilMoisture = maxIdealSoilMoisture;
	}
	public Plant() {
		super();
	}
	
	
}
