/**
 * 
 */
package com.oriaxx77.algorythm.prime;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oriaxx77
 */
public class BitSieveOfEratosthenes implements PrimeGenerator
{

    @Override
    public List<Integer> generatePrimes(int limit)
    {
        if ( limit <= 1 )
            return new ArrayList<Integer>();
        
        
        final BitSet primes = new BitSet();
        primes.set( 0, false );
        primes.set( 1, false );
        primes.set( 2, limit, true );
        
        for ( int i = 0; i <= Math.sqrt( limit ); i++ )
        {
            if ( primes.get(i) ) 
            {
                for ( int j = i*i; j < limit; j += i )
                    primes.clear(j);
            }
        }
        
        return primes.stream().boxed().collect( Collectors.toList() );
    }

}
