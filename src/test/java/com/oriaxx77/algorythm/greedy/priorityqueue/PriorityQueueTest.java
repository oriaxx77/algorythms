package com.oriaxx77.algorythm.greedy.priorityqueue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// TODO:work on corner cases. Like empty queue and poll. More elements than initial capacity etc...
public class PriorityQueueTest 
{
	@Test
	public void test()
	{
		//NOTE: you cannot really test poll without add
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>( Integer::compareTo );
		IntStream.rangeClosed(0, 8).forEach( queue::add );
		boolean alwaysMaxPolled = reverseRange(8,0).allMatch( (i) -> {return i == queue.poll().get();} );
		assertTrue( alwaysMaxPolled );
		
	}
	
	private IntStream reverseRange(int from, int to) 
	{
	    return IntStream.rangeClosed(from, to).map(i -> to - i + from - 1);
	}
}
