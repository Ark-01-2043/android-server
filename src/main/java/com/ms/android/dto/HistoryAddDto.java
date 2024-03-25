package com.ms.android.dto;

import java.time.LocalDateTime;

import com.ms.android.entity.Schedule;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryAddDto {
	private LocalDateTime time;
	
	private int schedule_id;
}
