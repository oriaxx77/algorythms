package com.oriaxx77.algorythm.list;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListReversalTest {

	private LinkedListReversal linkedListReversal = new LinkedListReversal();
	
	@Test
	public void testReverseWithNonNullListReturnReversedList(){
		Node<String> list = createList( new String[]{ "A", "B", "C" } );
		Node<String> reversedList = linkedListReversal.reverse( list ); 
		Node<String> expectedList = createList( new String[]{ "C", "B", "A"});
		assertEquals( expectedList, reversedList );
	}
	
	@Test(expected=NullPointerException.class)
	public void testReverseWithNullListExpectNullpointerException(){
		linkedListReversal.reverse( null );
	}
	
	private <T> Node<T> createList( T[] array ){
		Node<T> tail = null;
		Node<T> head = null;
		for ( T element :array ){
			Node<T> node = new Node<>( element, null);
			if ( tail != null ){
				tail.setNext( node );
			} else {
				head = node;
			}
			tail = node;
		}
		return head;
	}
	
}
