package com.oriaxx77.algorythm.numbertheorem;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreatestCommonDivisorTest
{
	@ParameterizedTest
	@MethodSource("getGreatestCommonDivisors")
	public void testGcdWithNoGcdExpectOne(GreatestCommonDivisor gcd){
		assertGcdWithExpected(gcd,7, 5, 1);
	}

	@ParameterizedTest
	@MethodSource("getGreatestCommonDivisors")
	public void testGcdWithGcdExpectNonZero(GreatestCommonDivisor gcd){
		assertGcdWithExpected(gcd, 6, 9, 3 );
	}
	
	private void assertGcdWithExpected(GreatestCommonDivisor gcd, int a, int b, int expected)
	{
		assertEquals( expected, gcd.gcd(a, b) );
	}

	public static Stream<GreatestCommonDivisor> getGreatestCommonDivisors(){
		return Stream.of( new EucledianGreatestCommonDivisor(), new BinaryGreatestCommonDivisor() );
	}
}
