package com.oriaxx77.algorythm.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A symbol table implemented with as N-way Trie.
 * It uses string keys and TValue values. N is the radix of the alphabet.
 *
 * @param <TValue> Type of the values in the symbol table.
 */
// TODO: refactor to Java 8. E.g. use streams? See #flattened(), #flattenedKeys()
// TODO: Analyze performance: Big O
public class TrieSymbolTable<TValue> implements SymbolTable<TValue> {
	
	
	
	private Node<TValue> root;
	private int keyCount = 0;
	private Alphabet alphabet;
	
	private static class Node<TValue> {
		private Optional<TValue> value = Optional.empty();
		private Node<TValue>[] children;
		
		@SuppressWarnings("unchecked")// Arrays :(
		public Node( int childrenCapacity ){
			children = new Node[childrenCapacity];
		}
	}
	
	public TrieSymbolTable( Alphabet alphabet ){
		Objects.requireNonNull( alphabet );
		this.alphabet = alphabet;
	}
	
	@Override
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
	
	@Override
	public void add( String key, TValue value ){
		Objects.requireNonNull( key );
		Objects.requireNonNull( value );
		
		root = add(root, key, value, 0 );
	}
	
	private Node<TValue> add( Node<TValue> node, String key, TValue value, int keyIdx ){
		if ( node == null )
			node = new Node<TValue>( alphabet.getRadix() );
		
		if ( key.length() == keyIdx ){
			if ( !node.value.isPresent() )
				keyCount += 1;
			node.value = Optional.of( value );
			return node;
		}
		
		int charIdx = alphabet.getIndex( key.charAt( keyIdx ) );
		node.children[ charIdx ] = add( node.children[charIdx], key, value, keyIdx+1 ); 
		return node;
	}
	
	
	@Override
	public boolean empty(){
		return keyCount == 0;
	}
	
	@Override
	public boolean contains( String key ){
		return get( key ).isPresent();
	}
	
	@Override
	public Iterable<String> keys(){
		return keysWithPrefix( "" );
	}
	
	
	@Override
	public Iterable<String> keysWithPrefix( String prefix ){
		List<String> matchingKeys = new ArrayList<String>();
		keysWithPrefix( root, prefix, 0, matchingKeys, new StringBuilder() );
		return matchingKeys;
	}
	
	private void keysWithPrefix( Node<TValue> node, String prefix, int prefixIdx, List<String> matchingKeys, StringBuilder keyBuilder ) {
		if ( prefixIdx >= prefix.length() ) {
			for ( int i = 0; i < alphabet.getRadix(); i++ ) {
				Node<TValue> child = node.children[i];
				if ( child != null ) {
					char currentChar = alphabet.getCharacter( i );
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
	
	@Override
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
			node.children[ alphabet.getIndex( currentChar ) ] = delete( node.children[ alphabet.getIndex(currentChar)], key, keyIdx+1 );
		}
		
		if ( node.value.isPresent() )
			return node;
		
		for ( int i = 0; i < alphabet.getRadix(); i++ ){
			if ( node.children[i] != null && node.children[i].value.isPresent() )
				return node;
		}
		
		return null;		
	}
		
	
	private Node<TValue> getChild( Node<TValue> n, char c ){
		return n.children[ alphabet.getIndex( c ) ];
	}
	
	
}