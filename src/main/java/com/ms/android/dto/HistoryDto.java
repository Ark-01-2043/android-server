package com.ms.android.dto;

import java.time.LocalDateTime;

import com.ms.android.entity.Schedule;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HistoryDto {
	private Integer id;
	private LocalDateTime time;
	private String moisture;
	
}
