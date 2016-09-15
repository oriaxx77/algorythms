package com.oriaxx77.algorythm.numbertheorem;

/**
 * Uses only subtraction and division by 2.
 * Input: a, b positive integers
 * Output: g and d such that g is odd and gcd(a, b) = g×2d
 */
public class BinaryGreatestCommonDivisor implements GreatestCommonDivisor {

	@Override
	public int gcd(int a, int b) {
		
		int d = 0;
		while ( bothEven(a,b)) {
			a = a/2;
			b = b/2;
			d = d+1;
		}
		while( a != b ){
			if ( even(a) ) { a = a/2; }
			else if ( even(b)){ b = b/2; }
			else if ( a > b ){ a = (a-b)/2; }
			else { b = (b-a)/2; }
		}
			
			
		return (int)(a*Math.pow(2, d));
	}
	
	private boolean bothEven( int a, int b){
		return a%2 == 0 && b%2 == 0; 
	}
	
	private boolean even( int a){
		return a%2 == 0;
	}

}
