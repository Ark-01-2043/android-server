package com.ms.android.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int moisture;
	private LocalDateTime time;
	private int repeat;
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
	public Schedule(Integer id, int moisture, LocalDateTime time, int repeat) {
		super();
		this.id = id;
		this.moisture = moisture;
		this.time = time;
		this.repeat = repeat;
	}
	public Schedule() {
		super();
	}
	
}
