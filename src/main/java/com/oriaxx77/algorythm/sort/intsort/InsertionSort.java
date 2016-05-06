/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

/**
 * Analysis. Iterate through array elements at indices 1,2,3, ... , n-1
 * Worst case we need to swap every element with every preceeding element. This means: c*1 + c*2 + c*3 + ... + c*(n-1) = c*(1+2+3+...+(n-1) 
 * c is  the time of the swap. It is constant so we can omit this: 1+2+3+...+(n-1) -> This is the arithmetic formula till n-1 
 * 
 * Arithmetic formula 1 + 2 + ... + (n-2) + (n-1) = n/2 * ( (1 + n-1)  + (2 + n-2 ) .... -> n/2 * n = n2 /2 
 * 
 * 
 * @author Oriaxx77
 *
 */
public class InsertionSort implements Sort
{

    private ElementSwapper swapper = new ElementSwapper();
    
    /* (non-Javadoc)
     * @see com.oriaxx77.algorythm.sort.intsort.Sort#sort(int[])
     */
    public void sort(int[] array)
    {
        if ( isSorted( array ) )
            return;
        
        for ( int i = 1; i < array.length; i++ )
        {
            for ( int j = i; j > 0; j-- )
            {
                if ( array[j] < array[j-1])
                    swapper.swap(array, j, j-1);
            }
        }
    }

}
