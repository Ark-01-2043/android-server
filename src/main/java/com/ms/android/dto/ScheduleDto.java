package com.ms.android.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
	private Integer id;
	private String moisture;
	private LocalDateTime time;
	private boolean auto;
	private int repeat;
	private boolean isActive;
	private boolean isDeleted;
	private LocalDateTime nextTime;
	
	
}
