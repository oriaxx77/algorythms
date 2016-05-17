/**
 * 
 */
package com.oriaxx77.algorythm.prime;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Oriaxx77
 */
@RunWith(Parameterized.class)
public class PrimeGeneratorTest 
{
	@Parameters
	public static Collection<PrimeGenerator> primeGenerators() {
		return Arrays.asList( new NaivePrimeGenerator() );
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
		assertEquals( Arrays.asList(2,3,5,7,9,11,13,17), generatedPrimes);
	}
	
	@Test
	public void testGeneratePrimes_BaseCase()
	{
		assertEquals( new ArrayList<Integer>(), primeGenerator.generatePrimes(1) );
	}

}
