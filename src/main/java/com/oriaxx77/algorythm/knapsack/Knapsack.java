package com.oriaxx77.algorythm.knapsack;

import java.util.List;

public interface Knapsack {
	
	long getMaxValue( Item[] items, int maxWeight );
	
	List<Item> getMaxValueItems( Item[] items, int maxWeight );
	
}
