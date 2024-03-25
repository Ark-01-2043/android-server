package com.ms.android.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ScheduleDto {
	private Integer id;
	private String moisture;
	private LocalDateTime time;
	private int repeat;
	private boolean isActive;
	private boolean isDeleted;
	
	
}
