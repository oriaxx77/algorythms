package com.oriaxx77.algorythm.prime;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Oriaxx77
 */
public class NaivePrimeGenerator implements PrimeGenerator 
{

	@Override
	public List<Integer> generatePrimes(int limit) 
	{
		List<Integer> primes = new ArrayList<Integer>();
		
		if ( limit <= 1 )
			return primes;
		
		int candidate = 2;
		while ( candidate < limit )
		{
			if ( isPrime(candidate, primes) )
			{
				primes.add( candidate );
				candidate = nextCandidate( candidate );
			}
		}
		
		return primes;
	}

	private boolean isPrime(int candidate, List<Integer> primes) 
	{
		int sqrt = (int)Math.sqrt( candidate );
		
		for (int i = 0; i < primes.size() && sqrt <= primes.get(i); i++ )
		{
			int divider = primes.get(i);
			if ( candidate % divider == 0) 
				return false;
		}
			
		return true;
	}

	
	private int nextCandidate( int currentCandidate )
	{
		return currentCandidate+2;
	}
}
