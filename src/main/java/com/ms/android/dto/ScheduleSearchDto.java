package com.ms.android.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSearchDto {
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	
	
}
