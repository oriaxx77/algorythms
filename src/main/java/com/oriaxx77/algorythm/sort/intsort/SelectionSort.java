/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

/**
 * How it works:
 * 
 * Divide the array into two parts: sorted, unsorted.
 * Select the smallest element from the unsorted and replace the left-most element
 * with this smallest element. Repeat it until the unsorted part is empty.
 * So in every iteration the sorted part (starting from 0) contains one more element.
 * 
 * 
 * E.g.:
 * 
 * original array: [| 3, 5, 8, 2, -1, 0]
 * i=1, min=-1,    [-1, | 5, 8, 2, 3, 0]
 * i=1, min=-0,    [-1, 0, | 8, 2, 3, 5]
 * i=1, min=-2,    [-1, 0, 2, | 8, 3, 5]
 * i=1, min=-3,    [-1, 0, 2, 3, | 8, 5]
 * i=1, min=-5,    [-1, 0, 2, 3, 5, | 8]
 * i=1, min=-8,    [-1, 0, 2, 3, 5, 8 |]

 * 
 * 
 * Performance:
 * Worst case: O(nPow2)
 */
public class SelectionSort implements Sort {
	
	private ElementSwapper swapper = new ElementSwapper();
	
	/* (non-Javadoc)
	 * @see com.oriaxx77.algorythm.sort.intsort.Sort#sort(int[])
	 */
	@Override
	public void sort(int[] array) {
		if ( isSorted(array) )
			return;
		
		for ( int i = 0; i < array.length; i++ ){
			int min = findMin( array, i );
			swapper.swap( array, i, min );
		}
	}
	
	private int findMin( int[] array, int start ){
		int min = start;
		for ( int i = start+1 ; i < array.length; i++ ){
			if ( array[min] > array[i] )
				min = i;
		}
		return min;
	}

}
