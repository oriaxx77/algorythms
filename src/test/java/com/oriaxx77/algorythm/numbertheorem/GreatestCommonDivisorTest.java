package com.oriaxx77.algorythm.numbertheorem;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GreatestCommonDivisorTest {
	
	private GreatestCommonDivisor gcd;
	
	@Parameters
	public static Collection<GreatestCommonDivisor> gcds(){
		return Arrays.asList( new EucledianGreatestCommonDivisor(), new BinaryGreatestCommonDivisor() );
	}
	
	
	public GreatestCommonDivisorTest( GreatestCommonDivisor gcd ){
		this.gcd = gcd;
	}
	
	@Test
	public void testGcdWithNoGcdExpectOne(){
		assertGcdWithExpected(7, 5, 1);
	}
	
	@Test
	public void testGcdWithGcdExpectNonZero(){
		assertGcdWithExpected( 6, 9, 3 );
	}
	
	private void assertGcdWithExpected( int a, int b, int expected){
		assertEquals( expected, gcd.gcd(a, b) );
	}
	
	
	
	
}
