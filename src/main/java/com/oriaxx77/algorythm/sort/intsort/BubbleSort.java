/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

import java.util.Objects;

/**
 * Performance:
 * Worst case: O( nPow2 )
 * Best case (already sorted) O(n)
 */
public class BubbleSort implements Sort {

	private ElementSwapper swapper = new ElementSwapper();
	
	/* (non-Javadoc)
	 * @see com.oriaxx77.algorythm.sort.intsort.Sort#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		
		Objects.requireNonNull( array );
		
		for ( int i = 0; i < array.length-1; i++ ){
			
			boolean sorted = true; // If no swap happened then it is sorted. 
			
			for ( int j = 0; j < array.length-1-i; j++ ){
				if ( array[j] > array[j+1] ){
					swapper.swap( array, j, j+1 );
					sorted = false;
				}
			}
			
			if ( sorted )
				return;
		}
	}
	

}
