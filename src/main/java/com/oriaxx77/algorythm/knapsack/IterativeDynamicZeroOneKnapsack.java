package com.oriaxx77.algorythm.knapsack;

import java.util.List;

/**
 * Iterative dynamic programming solution for zero-one knapsack.
 */
public class IterativeDynamicZeroOneKnapsack implements Knapsack {

	@Override
	public long getMaxValue(Item[] items, int maxWeight) {
		int[][] vIW = new int[items.length+1][maxWeight+1]; // ValueItemWeight matrix. col(y) -> number of items: 0,1,....,n row(x) -> weight: 0,1,....,maxWeight
		
		for ( int i=0; i <= items.length; i++ ) // y  (act item)
		{
			for ( int w=0; w <= maxWeight; w++ ) // x (act weight)
			{
				if ( i==0 ||w ==0 )
					vIW[i][w] = 0;
				else if ( items[i-1].getWeight() > w  )
					vIW[i][w] = vIW[i-1][w];
				else 
					vIW[i][w] = Math.max( items[i-1].getValue() + vIW[i-1][w-items[i-1].getWeight()], vIW[i-1][w]); 
			}
		}
		
		return vIW[items.length][maxWeight];
	}

	@Override
	public List<Item> getMaxValueItems(Item[] items, int maxWeight) {
		throw new RuntimeException( "Not implemented" );
	}

    
    
}
