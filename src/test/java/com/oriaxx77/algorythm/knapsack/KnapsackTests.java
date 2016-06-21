package com.oriaxx77.algorythm.knapsack;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class KnapsackTests {
	
	private Knapsack knapsack;
	
	@Parameters
	public static Collection<Knapsack> knapsacks() {
		return Arrays.asList( new RecursiveZeroOneKnapsack(), new IterativeDynamicZeroOneKnapsack() );
	}
		
	
	public KnapsackTests(Knapsack knapsack) {
		super();
		this.knapsack = knapsack;
	}


	@Test
	public void testGetMaxValue() {
		
		Item[] items = new Item[]{ new Item(60,10), new Item(100,20), new Item(120,30) };
		int maxWeight = 50;
		long expectedMaxValue = 220;
		long actualMaxValue = knapsack.getMaxValue( items, maxWeight);
		assertEquals( expectedMaxValue, actualMaxValue);	
	}
}
