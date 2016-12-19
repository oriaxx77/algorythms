package com.oriaxx77.algorythm.sort.intsort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class SortTest
{
    @Parameters
    public static Collection<Sort> sorts() {
        return Arrays.asList(new Sort[] {     
                 new InsertionSort(), new TopDownMergeSort(), new BottomUpMergeSort(), new QuickSort(), new BubbleSort(),
                 new SelectionSort()
           });
    }

    private Sort sort;
    
    public SortTest( Sort sort )
    {
        this.sort = sort;
    }
    
    
    @Test
    public void testSort_Successful() 
    {
        int[] array = getUnsortedArray();
        sort.sort( array );
        assertArrayEquals( getSortedArray(), array);
    }
    
    private int[] getUnsortedArray()
    {
        return new int[]{ 3,5,8,2,-1,0};
    }
    
    private int[] getSortedArray()
    {
        return new int[]{-1,0,2,3,5,8};
    }
    
}
