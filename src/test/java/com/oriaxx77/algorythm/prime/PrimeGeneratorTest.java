/**
 * 
 */
package com.oriaxx77.algorythm.prime;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Oriaxx77
 */
@RunWith(Parameterized.class)
public class PrimeGeneratorTest 
{
	@Parameters
	public static Collection<PrimeGenerator> primeGenerators() {
	    return Arrays.asList( new NaivePrimeGenerator(), new BitSieveOfEratosthenes() );
	}
		
	private PrimeGenerator primeGenerator;
	
	public PrimeGeneratorTest( PrimeGenerator primeGenerator )
	{
		this.primeGenerator = primeGenerator;
	}
	
	@Test
	public void testGeneratePrimes_UpTo18() 
	{
		List<Integer> generatedPrimes = primeGenerator.generatePrimes( 18 );
		List<Integer> expectedPrimes =  Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		assertThat( expectedPrimes , is( generatedPrimes ) );
	}
	
	@Test
	public void testGeneratePrimes_BaseCase()
	{
	    List<Integer> generatedPrimes = primeGenerator.generatePrimes(1);
	    List<Integer> expectedPrimes = new ArrayList<Integer>();
		assertThat( expectedPrimes, is( generatedPrimes ) );
	}

}
