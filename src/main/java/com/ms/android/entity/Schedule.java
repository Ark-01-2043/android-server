package com.ms.android.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private int moisture;
	private LocalDateTime time;
	private int repeat;
	private boolean auto;
	private int plantId;
	private boolean isActive;
	private boolean isDeleted;
	public Schedule(Integer id, int moisture, LocalDateTime time, int repeat, boolean auto, int plantId,
			boolean isActive, boolean isDeleted) {
		super();
		this.id = id;
		this.moisture = moisture;
		this.time = time;
		this.repeat = repeat;
		this.auto = auto;
		this.plantId = plantId;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}
	public Schedule() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getMoisture() {
		return moisture;
	}
	public void setMoisture(int moisture) {
		this.moisture = moisture;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public int getRepeat() {
		return repeat;
	}
	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
	public boolean isAuto() {
		return auto;
	}
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
