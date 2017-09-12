package com.oriaxx77.algorythm.util;

public class Numbers {
	public static void requirePositive( int n ){
		if ( n <= 0 )
			throw new RuntimeException( n + " must be > 0");
	}
}
