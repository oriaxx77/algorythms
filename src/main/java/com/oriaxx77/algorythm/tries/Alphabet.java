package com.oriaxx77.algorythm.tries;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Alphabet 
{
	private Map<Integer,Character> indexToCharacterMap = new HashMap<>();
	private Map<Character,Integer> characterToIntegerMap = new HashMap<>();
	private int radix;
	
	
	public Alphabet( String characters )
	{
		Objects.requireNonNull( characters );
		
		BitSet existenceSet = new BitSet( characters.length() );
		for ( int i = 0; i < characters.length(); i++ ) {
			char character = characters.charAt( i );
			if ( existenceSet.get( i ) ) 
				throw new IllegalArgumentException( "Duplicated character in alphabet: " + character );
			existenceSet.set( i );
			indexToCharacterMap.put( i, character );
			characterToIntegerMap.put( character, i );
		}	
		radix = characters.length();
	}
	
	public int getIndex( char character )
	{
		if ( !characterToIntegerMap.containsKey( character ) )
			throw new IllegalArgumentException( "No such character in alphabet: " + character );
		return characterToIntegerMap.get( character );
	}
	
	public char getCharacter( int index )
	{
		if ( !indexToCharacterMap.containsKey( index ) )
			throw new IllegalArgumentException( "Index out of range for alpabet: " + index );
		return indexToCharacterMap.get( index  );
	}
	
	public int getRadix()
	{
		return radix;
	}

	
}
