package com.ms.android.dto;

import java.time.LocalDateTime;

public class ScheduleSearchDto {
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDateTime getToDate() {
		return toDate;
	}
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	public ScheduleSearchDto(LocalDateTime fromDate, LocalDateTime toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public ScheduleSearchDto() {
		super();
	}
	
}
