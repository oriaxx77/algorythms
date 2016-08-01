package com.oriaxx77.algorythm.numbertheorem;

/**
 * The Euclidean algorithm can be used to find the greatest common 
 * divisor of two integers and to find integers x and y such that ax+by=d.
 * 
 *  gcd(a,0) = a
 *  gcd(a,b) = gcd(b,a%b) 
 * 
 *
 */
public class EucledianGreatestCommonDivisor implements GreatestCommonDivisor{

	@Override
	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b,a%b);
	}

}
