package com.oriaxx77.algorythm.greedy.activityselection;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ActivitySelectorTest 
{
	
	@Test
	public void testSelectActivities()
	{
		// Given
		LocalDateTime now = LocalDateTime.now();
		Activity activity1 = new Activity( now.plusDays(0), now.plusDays(1) );
		Activity activity2 = new Activity( now.plusDays(0), now.plusDays(2) );
		Activity activity3 = new Activity( now.plusDays(0), now.plusDays(2) );
		Activity activity4 = new Activity( now.plusDays(2), now.plusDays(3) );
		List<Activity> activities = Arrays.asList( activity1, activity2, activity3, activity4 );
		
		// When
		List<Activity> actualSelectedActivities = new ActivitySelector().select(activities, 2);
		
		// Then
		List<Activity> expectedSelectedActivities = Arrays.asList( activity1, activity4 );
		Assert.assertEquals( expectedSelectedActivities, actualSelectedActivities );
		
	}
			
}
