package com.oriaxx77.algorythm.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


// TODO: create interface
// TODO: define tests
// TODO: define operations
// TODO: implement missing operations.
public class LowercaseAtoZTrie {
	
	private static final int NUMBER_OF_CHARACTERS = 26;
	
	private LowercaseAtoZTrie[] children = new LowercaseAtoZTrie[NUMBER_OF_CHARACTERS];
	private int childCount = 0;
	private int keyCount = 0;
	private String value = null;
	private boolean isKey = false;
		
	public void add( String key ){
		Objects.requireNonNull( key );
		add( key, 0 );
	}
	
	public void add( String... keys ){
		Objects.requireNonNull( keys );
		for ( String key :keys )
			add( key, 0);
	}
	
	private void add( String key, int index ){		
		if ( index == key.length() ){
			isKey = true;
			return;
		}
		
		char currentChar = key.charAt( index );
		LowercaseAtoZTrie child = getChild( currentChar );
		if ( child == null ){
			child = new LowercaseAtoZTrie();
			child.value = key.substring(0,index+1);
			setChild( currentChar, child );
			childCount++;
		}
		child.add( key, index+1 );
	}
	
	private LowercaseAtoZTrie getChild( char c ){
		return children[ getCharIndex(c) ] ;
	}
	
	private void setChild( char c, LowercaseAtoZTrie node){
		children[ getCharIndex(c) ] = node;
	}
	
	public boolean isKey( String key ){
		return isKey( key, 0);
	}
	
	private boolean isKey( String key, int index ){
		if ( index == key.length() && isKey )
			return true;
		
		char currentKeyChar = key.charAt( index );
		LowercaseAtoZTrie child = getChild( currentKeyChar );
		if ( child == null )
			return false;
		return child.isKey( key, index+1 );
	}
	
	public Iterable<String> keysWithPrefix( String prefix ){
		List<String> matchingKeys = new ArrayList<String>();
		keysWithPrefix( prefix, 0, matchingKeys );
		return matchingKeys;
	}
	
	private void keysWithPrefix( String prefix, int index, List<String> matchingKeys ){
		if ( index >= prefix.length() ) {
			Arrays.stream( children ).filter( Objects::nonNull ).forEach( child -> {	
				if ( child.isKey )
					matchingKeys.add( child.value );
				if ( child.childCount != 0 )
					child.keysWithPrefix( prefix, index+1, matchingKeys );
			} );
			
			return;
		}
	
		// Find the matching prefix part recursively.
		char currentKeyChar = prefix.charAt( index );
		LowercaseAtoZTrie child = getChild( currentKeyChar );
		if ( child != null ) {
			if ( child.isKey)
				matchingKeys.add( child.value );
			child.keysWithPrefix( prefix, index+1, matchingKeys );
		}	
	}
		
	@Override
	public String toString() {
		return "[value="+value+", isWord="+isKey+", childCount=" + childCount +"]";
	}
	
	public int findCount( String key ){
		return findCount( key, 0 );
	}
	
	public int findCount( String key, int index ){
		if ( index == key.length() ){
			return childCount;
		}
		
		LowercaseAtoZTrie child = getChild( key.charAt( index ) );
		if ( child == null ) {
			return 0;
		}
		return child.findCount( key, index+1 );
	}

	private Stream<LowercaseAtoZTrie> flattened() {
		return Stream.concat( Stream.of(this),
							  Arrays.stream( children).filter(Objects::nonNull).flatMap( LowercaseAtoZTrie::flattened ));
    }
	
	public Stream<String> flattenedKeys(){
		return flattened().filter( trie -> trie.isKey ).map( trie -> trie.value );				  
	}
	
	public Stream<String> flattenedPrefixes(){
		return flattened().map( trie -> trie.value );
	}
	
	
	// Helpers
	private static int getCharIndex( char c ) {
		return c - 'a';
	}

}
	
	

