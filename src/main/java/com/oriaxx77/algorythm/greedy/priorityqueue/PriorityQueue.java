package com.oriaxx77.algorythm.greedy.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import com.oriaxx77.algorythm.sort.intsort.ElementSwapper;
import com.oriaxx77.algorythm.util.Numbers;

/**
 * Priority Queue implemented with heap
 * A heap is a binary tree (in which each node contains a Comparable key value), with two special properties:

 * The ORDER property:

 * For every node n, the value in n is greater than or equal to the values in its children (and thus is also greater than or equal to all of the values in its subtrees).
 * The SHAPE property:

 * All leaves are either at depth d or d-1 (for some value d).
 * All of the leaves at depth d-1 are to the right of the leaves at depth d.
 * (a) There is at most 1 node with just 1 child. (b) That child is the left child of its parent, and (c) it is the rightmost leaf at depth d.
 *
 * @param <E>
 */
public class PriorityQueue<E> 
{
	private final static int INITIAL_CAPACITY=20;
	
	private Object[] elements;  // TODO: is it worth to start to use it from index 1 and leave 0 unused?
	private int elementsCount;
	private Comparator<? super E> comparator;

	public PriorityQueue( Comparator<? super E> comparator )
	{
		this.comparator = comparator;
		this.elements = new Object[INITIAL_CAPACITY];
	}
	
	private Optional<E> replaceRootWithLastLeaf()
	{
		if ( elementsCount == 0 )
		{
			return Optional.empty();
		}
		else if ( elementsCount == 1 )
		{
			@SuppressWarnings("unchecked")
			Optional<E> max = ((Optional<E>)Optional.of(elements[0]));
			elementsCount--;
			elements[0] = null;
			return max;
		}
		else
		{
			@SuppressWarnings("unchecked")
			Optional<E> max = ((Optional<E>)Optional.of(elements[0])); 
			elements[0] = elements[elementsCount-1]; 
			elements[elementsCount-1] = null; 
			elementsCount--;
			return max;
		}
	}
	
	private void swapRootDownForOrder()
	{
		if ( elementsCount <= 1 )
			return;
		
		Node node = new Node(0);			
		while ( node.lessThanItsChildren() )
		{
			node = swapWithGreaterChild( node );
		}
	}
	
	private Node swapWithGreaterChild( final Node node )
	{
		Node greaterChild = node.getGreaterChild().orElseThrow( () -> {return new RuntimeException( "Greater child expected!" );} );
		new ElementSwapper().swap( elements, node.i, greaterChild.i );
		return greaterChild;
	}
	
	/**
	 * Removes the max from the queue.
	 * @return Max element from the queue if exists.
	 */
	@SuppressWarnings("unchecked")
	public Optional<E> poll()
	{
		// Replace the value in the root with the value at the end of the array 
		// (which corresponds to the heap's rightmost leaf at depth d). 
		// Remove that leaf from the tree.
		// Now work your way down the tree, swapping values to restore the order property: 
		// each time, if the value in the current node is less than one of its children, then swap its value 
		// with the larger child (that ensures that the new root value is larger than both of its children).
		
		Optional<E> max = replaceRootWithLastLeaf();
		swapRootDownForOrder();
		return max;		
	}
	
	public void add( E element )
	{
		/*
		Add the new value at the end of the array; that corresponds to adding it as a new rightmost leaf in the tree 
		(or, if the tree was a complete binary tree, i.e., all leaves were at the same depth d, then that corresponds to adding a new leaf at depth d+1).
		Step 1 above ensures that the heap still has the shape property; however, it may not have the order property. 
		We can check that by comparing the new value to the value in its parent. 
		If the parent is smaller, we swap the values, and we continue this chec
		k-and-swap procedure up the tree until we find that the order property holds, or we get to the root.
		*/
		Objects.requireNonNull( element );
		allocateMoreSpaceIfNeeded();
		addNewElementAsLastLeaf( element );
		swapLastLeafUpForOrder();
	}
	
	private void allocateMoreSpaceIfNeeded()
	{
		if ( elements.length-1 == elementsCount )
		{
			Object[] newElements = new Object[elements.length*2];
			System.arraycopy(elements, 0, newElements, 0, elements.length);
		}
	}
	
	private void addNewElementAsLastLeaf( E element)
	{
		elements[elementsCount] = element;
		elementsCount++;
	}
	
	private void swapLastLeafUpForOrder()
	{
		Node added = new Node(elementsCount-1);
		while ( added.greaterThanParent() )
		{
			swapWithParent( added );
			added = added.parent().orElseThrow( () -> {return new RuntimeException("Parent node expected!"); });
		}
	}
	
	
	private void swapWithParent( Node node )
	{
		node.parent().ifPresent( parent -> { new ElementSwapper().swap( elements, node.i, parent.i );} );
	}
	
	
	
	private class Node implements Comparable<Node>
	{
		int i;
		public Node( int i)
		{ 
			this.i = i; 
		}
		
		public Optional<Node> getGreaterChild() 
		{
			return Stream.of( leftChild(), rightChild() )
					  .filter( Optional::isPresent )
					  .map( Optional::get )
					  .max( Node::compareTo );
		}

		public boolean lessThanItsChildren() 
		{
			return lessThan( rightChild() ) || lessThan( leftChild() );
		}
		
		private boolean lessThan( Optional<Node> node )
		{
			return node.map( this::compareTo ).map( Numbers::negative ).orElse(Boolean.FALSE);
		}

		private Optional<Node> leftChild()
		{
			int leftChildI = 2*i+1;
			return ( leftChildI < elementsCount ) ? Optional.of( new Node(leftChildI) ) : Optional.empty();
		}
		
		private Optional<Node> rightChild()
		{ 
			int rightChildI = 2*i+2; 
			return ( rightChildI < elementsCount ) ? Optional.of( new Node(rightChildI) ) : Optional.empty();
		}		
		
		public Optional<Node> parent()
		{ 
			if ( isRoot() ) 
				return Optional.empty();

			int parentI = (i%2 == 0 ? i/2-1 : i/2 );
			return Optional.of( new Node(parentI) );
		} 
		
		public boolean isRoot()
		{ 
			return i == 0; 
		};
		
		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(PriorityQueue<E>.Node other) 
		{
			return comparator.compare( (E)elements[i], (E)elements[other.i]);
		}
		
		public boolean greaterThanParent()
		{
			return parent().map( this::compareTo )
						   .map( (i) -> { return i >= 0;})
						   .orElse( Boolean.FALSE );
			
		}
	}
	
	@Override
	public String toString() 
	{
		return Arrays.toString( elements );
	}
	
}
