package com.ms.android.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schedules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int moisture;
	private LocalDateTime time;
	private int repeat;
	private boolean auto;
	private int plantId;
	private boolean actived;
	private boolean deleted;
	
	
	
	
}
