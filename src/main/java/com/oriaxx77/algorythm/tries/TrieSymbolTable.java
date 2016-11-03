package com.oriaxx77.algorythm.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A symbol table implemented with as N-way Trie.
 * It uses string keys and TValue values. N is the radix of the alphabet.
 *
 * @param <TValue> Type of the values in the symbol table.
 */
// TODO: Use alphabet
// TODO: Extract interface
// TODO: refactor to Java 8. E.g. use streams? See #flattened(), #flattenedKeys()
// TODO: Analyze performance: Big O
public class TrieSymbolTable<TValue> {
	// TODO: move into alphabet
	private static int RADIX = 26;
	
	private Node<TValue> root;
	private int keyCount = 0;
	
	private static class Node<TValue> {
		private Optional<TValue> value = Optional.empty();
		@SuppressWarnings("unchecked")// Arrays :(
		private Node<TValue>[] children = new Node[RADIX];
	}
	
	public TrieSymbolTable(){
		
	}
	
	public Optional<TValue> get( String key ){
		Objects.requireNonNull( key );
		return get( root, key, 0 );
	}
	
	private Optional<TValue> get( Node<TValue> node, String key, int keyIdx ){
		if ( node == null )
			return Optional.empty();
			
		if ( key.length() == keyIdx )
			return node.value;
		
		Node<TValue> child = getChild(node, key.charAt(keyIdx));
		return get( child, key, keyIdx+1 );
		
	}
	
	public void add( String key, TValue value ){
		Objects.requireNonNull( key );
		Objects.requireNonNull( value );
		
		root = add(root, key, value, 0 );
	}
	
	private Node<TValue> add( Node<TValue> node, String key, TValue value, int keyIdx ){
		if ( node == null )
			node = new Node<TValue>();
		
		if ( key.length() == keyIdx ){
			if ( !node.value.isPresent() )
				keyCount += 1;
			node.value = Optional.of( value );
			return node;
		}
		
		int charIdx = getCharIdx( key.charAt( keyIdx ) );
		node.children[ charIdx ] = add( node.children[charIdx], key, value, keyIdx+1 ); 
		return node;
	}
	
	
	public boolean empty(){
		return keyCount == 0;
	}
	
	public boolean contains( String key ){
		return get( key ).isPresent();
	}
	
	public Iterable<String> keys(){
		return keysWithPrefix( "" );
	}
	
	
	public Iterable<String> keysWithPrefix( String prefix ){
		List<String> matchingKeys = new ArrayList<String>();
		keysWithPrefix( root, prefix, 0, matchingKeys, new StringBuilder() );
		return matchingKeys;
	}
	
	private void keysWithPrefix( Node<TValue> node, String prefix, int prefixIdx, List<String> matchingKeys, StringBuilder keyBuilder ) {
		if ( prefixIdx >= prefix.length() ) {
			for ( int i = 0; i < RADIX; i++ ) {
				Node<TValue> child = node.children[i];
				if ( child != null ) {
					char currentChar = getChar( i );
					keyBuilder.append( currentChar );
					if ( child.value.isPresent() ) {
						matchingKeys.add( keyBuilder.toString() );
					}
					keysWithPrefix( child, prefix, prefixIdx+1, matchingKeys, keyBuilder );
					keyBuilder.deleteCharAt( prefixIdx );
				}
			}

			return;
		}
		
		char currentChar = prefix.charAt( prefixIdx );
		Node<TValue> child = getChild( node, currentChar );
		if ( child != null ) {
			keyBuilder.append( currentChar );
			keysWithPrefix( child, prefix, prefixIdx+1, matchingKeys, keyBuilder );
		}
		
	}
	
	public void delete( String key ){
		root = delete( root, key, 0);
	}
	
	private Node<TValue> delete( Node<TValue> node, String key, int keyIdx ){

		if ( node == null )
			return null;
		
		if ( key.length() == keyIdx ) {
			if ( node.value.isPresent() )
				node.value = Optional.empty();
		} else {
			char currentChar = key.charAt( keyIdx );
			node.children[ getCharIdx( currentChar ) ] = delete( node.children[ getCharIdx(currentChar)], key, keyIdx+1 );
		}
		
		if ( node.value.isPresent() )
			return node;
		
		for ( int i = 0; i < RADIX; i++ ){
			if ( node.children[i] != null && node.children[i].value.isPresent() )
				return node;
		}
		
		return null;		
	}
		
	// TODO: move it to Node?
	private Stream<Node<TValue>> flattened( Node<TValue> node ) {
		return Stream.concat( Stream.of( node ),
							  Arrays.stream( node.children ).filter( Objects::nonNull ).flatMap( this::flattened ));
    }
	
	// TODO: move it to Node?
	public Stream<TValue> flattenedKeys( Node<TValue> node ){
		return flattened( node ).filter( n -> n.value.isPresent() ).map( n -> n.value.get() );				  
	}
	
	private Node<TValue> getChild( Node<TValue> n, char c ){
		return n.children[ getCharIdx(c) ];
	}
	
	private static int getCharIdx( char c ){
		return c - 'a';
	}
	
	private static char getChar( int idx ){
		return (char) (idx + 'a');
	}
	
}