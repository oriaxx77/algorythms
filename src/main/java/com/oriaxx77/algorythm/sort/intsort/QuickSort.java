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
        if ( isSorted( array ) )
            return ;
        
        sort( array, 0, array.length-1 );
    }

    private void sort(int[] a, int lo, int hi)
    {
        if ( lo < hi )
        {    
            int p = partition( a, lo, hi);
            sort( a, lo, p);
            sort( a, p+1, hi );
        }
        
    }

    private int partition(int[] a, int lo, int hi)
    {
        int pivot = a[lo];
        int i = lo;
        int j = hi;
        
        while( true )
        {
            while( a[i] < pivot )
                i++;
            
            while( a[j] > pivot )
                j--;
            
            if ( i >= j )
                return j;
            
            swapper.swap( a, i, j);
        }
    }

}
