/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

/**
 * @author Oriaxx77
 */
public class BottomUpMergeSort implements Sort
{

    @Override
    public void sort(int[] array)
    {
        if ( isSorted(array) )
            return;
        
        int[] auxArray = new int[array.length];
        System.out.println( "N : " + array.length );
        for ( int width = 1; width < array.length; width = 2*width )  // lg(n)
        {
            for ( int low = 0; low < array.length; low = low+width*2 ) // n + 2*n/2 + 4*n/4 + 8*n/8 ....
            {
                int high = Math.min( low + (width*2), array.length);
                int mid = Math.min( low + width, array.length);
                merge( array, auxArray, low, mid, high );
            }
        }
        
    }

    private void merge(int[] array, int[] auxArray, int low, int mid, int high)
    {
        if ( high - low <= 1 )
            return;
        
        int i = low;
        int j = mid;
        
        for ( int k = low; k < high; k++ )
        {
            if ( i < mid && ( j >= high || array[i] <= array[j] ) )
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
