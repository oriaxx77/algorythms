package com.oriaxx77.algorythm.sort.intsort;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Oriaxx77
 */
public class ElementSwapperTest
{
    @Test
    public void testSwap()
    {
    		// Given
        int[] array = new int[]{1,2,3};
        ElementSwapper swapper = new ElementSwapper();
        // When
        swapper.swap(array, 0, 1);
        // Then
        Assert.assertArrayEquals( new int[]{2,1,3}, array );
    }
}
