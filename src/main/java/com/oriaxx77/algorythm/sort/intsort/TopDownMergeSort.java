/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

/**
 * Analysis of Merge Sort
 * 1) Divide and Conquer
 * 2) Recursive
 * 3) Stable // Preserve the order of the objects with the same key
 * 4) Not in-place // The extra space is dependent on the size of the original array 
 * 
 * Space complexity O(n)
 * 
 * Time complexity O(nlogn) time-complexity
 *                      Subproblem size         Total merging time
 *                                                  for all subproblems of this size
 *                  n                                       c*n
 *          n/2             n/2                             2 * c*n/2 = c*n
 *    n/4     n/4      n/4     n/4                          4 * c*n/2 = c*n
 *  n/8 n/8 n/8 n/8 n/8 n/8 n/8 n/8                         8 * c*n/8 = c*n
 *   .                                                              .
 *   .                                                              .
 *   .                                                              .
 *   .                                                              .
 *  1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1                 c*n
 *  
 *  How many levels do we have? lg(n) + 1
 *  
 *  (lg(n)+1) * c*n
 *  we can ignore the constants -> n*lg(n)
 *  
 *          
 *          
 *          
 * @author Oriaxx77
 */
public class TopDownMergeSort implements Sort
{
    @Override
    public void sort( int[] array )
    {
        if ( isSorted(array) )
            return;
        
        int[] auxArray = new int[array.length];
        sort( array, auxArray, 0, array.length );
    }

    private void sort( int[] array, int[] auxArray, int low, int high )
    {
        if ( high-low <= 1 )
            return;
        
        int mid = low + (high-low)/2;
        sort( array, auxArray, 0, mid);
        sort( array, auxArray, mid, high );
        merge( array, auxArray, 0, mid, high);
    }

    private void merge(int[] array, int[] auxArray, int low, int mid, int high)
    {
        for ( int i = low; i < high; i++ )
            auxArray[i] = array[i];
        
        int i = low;
        int j = mid;
        
        for ( int k = low; k < high; k++ )
        {
            if ( i < mid && ( j >= high || array[i] < array[j] ) )
            {
                auxArray[k] = array[i];
                i++;
            }
            else
            {
                auxArray[k] = array[j];
                j++;
            }            
        }
        
        for ( int m = low; m < high; m++ )
            array[m] = auxArray[m];
    }
    
    
    
    
}
