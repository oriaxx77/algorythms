package com.oriaxx77.algorythm.knapsack;

import java.util.List;

/**
 * Naive recursive based solution for the 0-1 knapsack problem.
 * It may computes the same subproblems many times instead of 
 * computing once then storing it.
 */
public class RecursiveZeroOneKnapsack implements Knapsack {

	@Override
	public long getMaxValue( Item[] items, int maxWeight ) {
		return getMaxValue( items, maxWeight, items.length );
	}

	private long getMaxValue( Item[] items, int maxWeight, int n) {
		
		// base case: no item or zero maxWeight
		if ( n == 0 || maxWeight == 0 )
			return 0;

		// Weight of the nth item is more than maxWeight -> 
		// We cannot include this item into the optimal solutions.
		// Fall back to to the nth-1 item.
		if ( items[n - 1].getWeight() > maxWeight)
			return getMaxValue( items, maxWeight, n-1);
		
		// Return the maximum of these two cases:
		// 1) nth item included
		// 2) nth item is not included
		
		long includedValue = items[n-1].getValue() + getMaxValue(items, maxWeight-items[n-1].getWeight(), n-1);
		long notIncludedValue = getMaxValue(items, maxWeight, n - 1);
		return Math.max( includedValue, notIncludedValue);
	}

	@Override
	public List<Item> getMaxValueItems( Item[] items, int maxWeight) {
		throw new RuntimeException( "Not implemented." );
	}		
		

}
