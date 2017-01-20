package com.oriaxx77.algorythm.sort.intsort;


// TODO: create a heap data structure
public class MaxHeapSort implements Sort{

	private ElementSwapper swapper = new ElementSwapper();
	
	@Override
	public void sort(int[] array) {
		
		if ( isSorted(array) )
			return;
		
		buildMaxHeap( array );		
		sort( array, array.length-1 );
		
	}
	
	private void buildMaxHeap( int[] array ){
		
		for ( int i = array.length / 2 ; i >= 0 ; i-- )
			heapify( array, array.length, i );
		
	}
	
	
	// Utilize that a max-heap's 0th element is the max. 
	// 1. Swap the max with the first non-sorted element (length-1 th element) 
	// 2. The swap screwed up the heap property of the heap. heapify it.
	// 3. Go back to step 1) until we have have non-sorted elements.
	//
	private void sort( int[] heap, int nextNotSorted ){
		// Do it until we have non-sorted elements.
		// Elements that are not sorted
		while ( nextNotSorted != 0 ){
		
			// The first element is the max int a max-heap.
			// Swap this first element with the next not sorted element
			swapper.swap( heap, 0, nextNotSorted );
		
			// The swap will screw up the heap property of our heap
			// Fix this.
			heapify( heap, nextNotSorted, 0 );
		
			// Move to the next not sorted element.
			nextNotSorted = nextNotSorted - 1;
		}			
	}
	
	private void heapify( int[] heap, int heapSize, int element ){
		int largest = element;
		int left = (largest*2)+1;
		int right = (largest*2)+2;
		
		if ( left < heapSize && heap[left] > heap[largest] )
			largest = left;
		
		if ( right < heapSize && heap[right] > heap[largest] )
			largest = right;
		
		if ( largest != element ) {
			swapper.swap( heap, largest, element);
			heapify( heap, heapSize, largest );
		}
	}
	

}
