package com.oriaxx77.algorythm.greedy.activityselection;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Activity 
{
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	
	
	
	public Activity(LocalDateTime start, LocalDateTime finish) 
	{
		super();
		Objects.requireNonNull( start );
		Objects.requireNonNull( finish );
		if ( start.isAfter( finish ))
			throw new IllegalArgumentException( "Start date cannot be after the finish date." );
		this.startDate = start;
		this.finishDate = finish;
	}

	public LocalDateTime getStartDate() 
	{
		return startDate;
	}
	
	public LocalDateTime getFinishDate() 
	{
		return finishDate;
	}

	@Override
	public String toString() 
	{
		return "Activity [startDate=" + startDate + ", finishDate=" + finishDate + "]";
	}
	
	
	
	
}
