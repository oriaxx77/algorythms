package com.oriaxx77.algorythm.tries;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlphabetTest 
{
	private String characters = "abcd";
	private Alphabet alphabet = new Alphabet( characters );
	
	// #getIndex
	
	@Test
	public void testGetIndex_withValidCharacter_returnIndex()
	{
		IntStream.range( 0, characters.length() ).forEach( i -> { 
			assertTrue(  i == alphabet.getIndex( characters.charAt(i) ) );
		} );
		
	}
	
	@Test
	public void testGetIndex_withInvalidCharacter_throwIllegalArgumentException()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			alphabet.getIndex( 'x' );
		});
	}
	
	
	// # getCharacter
	
	public void getCharacter_withValidIndex_returnCharacter()
	{
		IntStream.range(0, characters.length() )
		 .forEach( i -> {
			 assertTrue( characters.charAt(i) == alphabet.getCharacter(i) );
		 } );
	}
	
	public void getCharacter_withInvalidIndex_throwIllegalArgumentException()
	{
		alphabet.getCharacter( -1 );
	}
	
	// # getRadix
	
	public void getRadix()
	{
		assertEquals( characters.length(), alphabet.getRadix() );
	}

	
}
