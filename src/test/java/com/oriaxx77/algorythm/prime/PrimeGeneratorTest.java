/**
 * 
 */
package com.oriaxx77.algorythm.prime;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeGeneratorTest
{
	
	@ParameterizedTest
	@MethodSource("getPrimeGenerators")
	public void testGeneratePrimes_UpTo18(PrimeGenerator primeGenerator)
	{
		List<Integer> generatedPrimes = primeGenerator.generatePrimes( 18 );
		List<Integer> expectedPrimes =  Arrays.asList(2, 3, 5, 7, 11, 13, 17);
		assertThat( expectedPrimes , is( generatedPrimes ) );
	}

	@ParameterizedTest
	@MethodSource("getPrimeGenerators")
	public void testGeneratePrimes_BaseCase(PrimeGenerator primeGenerator)
	{
	    List<Integer> generatedPrimes = primeGenerator.generatePrimes(1);
	    List<Integer> expectedPrimes = new ArrayList<Integer>();
		assertThat( expectedPrimes, is( generatedPrimes ) );
	}

	// NOTE: static because it is a parameter source.
	private static Stream<PrimeGenerator> getPrimeGenerators()
	{
		return Stream.of(new NaivePrimeGenerator(), new BitSieveOfEratosthenes());
	}
}
