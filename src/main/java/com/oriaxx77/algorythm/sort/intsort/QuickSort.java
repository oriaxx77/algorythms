/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;


/**
 * @author Oriaxx77
 *
 */
public class QuickSort implements Sort
{
    
    private ElementSwapper swapper = new ElementSwapper();

    /* (non-Javadoc)
     * @see com.oriaxx77.algorythm.sort.intsort.Sort#sort(int[])
     */
    @Override
    public void sort(int[] array)
    {
       quickSort( array, 0, array.length-1 ); 
    }

    private void quickSort(int[] a, int lo, int hi)
    {
        if ( lo < hi )
        {
            int p = partition( a, lo, hi);
            quickSort( a, lo, p);
            quickSort( a, p+1, hi );
        }
        
    }

    private int partition(int[] a, int lo, int hi)
    {
        int pivot = a[lo];
        int i = lo; // lo inclusive
        int j = hi; // hi exclusive
        while ( true )
        {
            while ( a[i] < pivot )
                i++;
        
            while ( a[j] > pivot )
                j--;
        
            if ( i >= j)
                return j;
            
            swapper.swap( a, i, j );
        }
    }

}
