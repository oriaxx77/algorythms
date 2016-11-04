package com.oriaxx77.algorythm.tries;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class AlphabetTest 
{
	private String characters = "abcd";
	private Alphabet alphabet = new Alphabet( characters );
	
	// #getIndex
	
	@Test
	public void testGetIndex_withValidCharacter_returnIndex()
	{
		IntStream.range( 0, characters.length() ).forEach( i -> { 
			Assert.assertTrue(  i == alphabet.getIndex( characters.charAt(i) ) );
		} );
		
	}
	
	@Test( expected = IllegalArgumentException.class )
	public void testGetIndex_withInvalidCharacter_throwIllegalArgumentException()
	{
		alphabet.getIndex( 'x' ); 
	}
	
	
	// # getCharacter
	
	public void getCharacter_withValidIndex_returnCharacter()
	{
		IntStream.range(0, characters.length() )
		 .forEach( i -> {
			 Assert.assertTrue( characters.charAt(i) == alphabet.getCharacter(i) );
		 } );
	}
	
	public void getCharacter_withInvalidIndex_throwIllegalArgumentException()
	{
		alphabet.getCharacter( -1 );
	}
	
	// # getRadix
	
	public void getRadix()
	{
		Assert.assertEquals( characters.length(), alphabet.getRadix() );
	}

	
}
