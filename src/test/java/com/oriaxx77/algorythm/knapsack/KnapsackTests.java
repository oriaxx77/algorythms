package com.oriaxx77.algorythm.knapsack;



import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @RunWith(Parameterized.class)
public class KnapsackTests
{

	@ParameterizedTest
	@MethodSource("getKnapsack")
	public void testGetMaxValue(Knapsack knapsack)
	{
		Item[] items = new Item[]{ new Item(60,10), new Item(100,20), new Item(120,30) };
		int maxWeight = 50;
		long expectedMaxValue = 220;
		long actualMaxValue = knapsack.getMaxValue( items, maxWeight);
		assertEquals( expectedMaxValue, actualMaxValue);	
	}

	private static Stream<Knapsack> getKnapsack()
	{
		return Stream.of(new RecursiveZeroOneKnapsack(), new IterativeDynamicZeroOneKnapsack());
	}

}
