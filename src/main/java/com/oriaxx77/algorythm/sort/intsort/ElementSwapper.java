package com.oriaxx77.algorythm.sort.intsort;

/**
 * 
 * @author Oriaxx77
 *
 */
public class ElementSwapper
{
    public void swap( int[] array, int idx1, int idx2 )
    {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}
