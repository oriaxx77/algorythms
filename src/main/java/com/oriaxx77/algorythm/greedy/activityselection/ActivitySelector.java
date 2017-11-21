package com.oriaxx77.algorythm.greedy.activityselection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.oriaxx77.algorythm.util.Numbers;

/**
 * Problem:
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time.
 *
 * Clues:
 * - Order the activities based on start and finish time
 * - Pick the next activity that
 * 		- has the least finish time among the remaining activities
 * 		- the start time of the activity is greater or equal than the finish time of the previous
 * 
 * Algorythm:
 * 1) Sort the activities according to their finishing time
 * 2) Select the first activity from the sorted array and print it.
 * 3) Do following for remaining activities in the sorted array.
 * 	  a) If the start time of this activity is greater than or equal to the finish 
 *       time of previously selected activity then select this activity and print it.
 */
public class ActivitySelector 
{
	/**
	 * Select {@link limit} number of activities from {@link activities}.
	 * The number of selected activites can be less than the specified {@link limit} if there 
	 * is not enough activities in the {@link activities} list.
	 * 
	 * @param activities Activities to select from
	 * @param limit Max number of activities to select.
	 * @return List of selected activities in finish order.
	 */
	public List<Activity> select( List<Activity> activities, int limit )
	{
		Objects.nonNull( activities );
		Numbers.requirePositive( limit );
		
		List<Activity> sortedActivities = getActivitiesSortedByFinishDate( activities );
		return selectActivities( sortedActivities, limit );
	}

	

	private List<Activity> getActivitiesSortedByFinishDate( List<Activity> activities ) 
	{
		List<Activity> sortedActivities = new ArrayList<Activity>( activities );
		sortedActivities.stream().sorted( (a1,a2) -> a1.getFinishDate().compareTo(a2.getFinishDate()) );
		return sortedActivities;
	}
	
	
	
	private List<Activity> selectActivities(List<Activity> activities, int limit) 
	{
		return activities
				.stream()
				.reduce( (List<Activity>)new ArrayList<Activity>(),
						 this::accumulateActivities ,
						(List<Activity> l1,List<Activity> l2) ->{ l1.addAll(l2); return l1;} );
				
	}
	
	private List<Activity> accumulateActivities( List<Activity> selectedActivities, Activity candidate )
	{
		if ( selectedActivities.size() == 0 )
		{
			  selectedActivities.add( candidate );
		}
		else
		{
			Activity lastSelected = selectedActivities.get( selectedActivities.size()-1);
			if ( candidate.getStartDate().isAfter( lastSelected.getFinishDate() ))
				selectedActivities.add( candidate );
		}
		return selectedActivities;
	}
	
		
		
	
}
