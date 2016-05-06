/**
 * 
 */
package com.oriaxx77.algorythm.sort.intsort;

/**
 * Sorting algorythm for int arrays.
 * @author Oriaxx77
 */
public interface Sort
{
   /**
    * Sorts the provided array 
    * @param array
    */
   void sort( int[] array );
   
   /**
    * Checks if the provided array is already sorted.
    * @param array
    * @return 
    */
   default boolean isSorted( int[] array )
   {
       for ( int i = 0; i < array.length-1; i++ )
       {
           if ( array[i] > array[i+1] )
               return false;
       }
       return true;
   }
}
