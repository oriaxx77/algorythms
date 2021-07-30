package com.oriaxx77.algorythm.tries;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieSymbolTableTest {
	
	// #add()
	
	@Test
	public void testAdd_withNullKey_throwNullPointerException() {
		Assertions.assertThrows(NullPointerException.class, () -> buildEmptySymbolTable().add( null, "value"));
	}
	
	@Test()
	public void testAdd_withNullValue_throwNullPointerException(){
		Assertions.assertThrows(NullPointerException.class, () -> {
			buildEmptySymbolTable().add("key", null);
		});
	}
	
	@Test
	public void testAdd_withNonNulls_keyExistsWithValue(){
		SymbolTable<String> symbolTable = buildEmptySymbolTable();
		String key = "key";
		String value = "value";
		symbolTable.add( key, value);
		assertTrue( symbolTable.contains( key ) );
		assertEquals( value, symbolTable.get( key ).get() );
		
	}
	
	// #keys()
	
	@Test
	public void testKeys(){
		String[] actualKeys = toArray( buildTrieSymbolTable().keys() );
		assertArrayEquals( KEYS, actualKeys );
	}
	
	// #keysWithPrefix()
	
	@Test
	public void testKeysWithPrefix(){
		String[] actualKeys = toArray( buildTrieSymbolTable().keysWithPrefix( "aa" ) );
		String[] expectedKeys = new String[]{ "aabc", "aac" };
		assertArrayEquals( expectedKeys, actualKeys  );
	}
	
	
	// #exist()
	
	public void testContains_withExistingIntermediaryKey_returnTrue(){
		assertTrue( buildTrieSymbolTable().contains("a") );
	}
	
	public void testContains_withExistingLeafKey_returnTrue(){
		assertTrue( buildTrieSymbolTable().contains( "aabc" ) );
	}
	
	public void testExist_withNonExistingKey_returnFalse(){
		assertFalse( buildTrieSymbolTable().contains( "x" ) );
	}
	
	public void testExist_withNullKey_returnFalse(){
		assertFalse( buildTrieSymbolTable().contains( null ) );
	}
	
	// #delete()
	
	@Test
	public void testDelete_witsKeysInSymbolTable_expectKeysDoNotExist(){
		SymbolTable<String> symbolTable = buildEmptySymbolTable();
		for ( int i = KEYS.length-1; i >= 0; i-- ){
			symbolTable.delete( KEYS[i] );
			assertFalse( symbolTable.contains( KEYS[i] ) );
		}
	}
	
	// #empty()
	
	@Test
	public void testEmpty_withEmptyTrieSymbolTable_returnTrue(){
		assertTrue(  buildEmptySymbolTable().empty() );
	}
	
	public void testEmpty_withNonEmptyTrieSymbolTable_returnFalse(){
		assertFalse( buildTrieSymbolTable().empty() );
	}
	
	// Helpers
	
	private static final String[] KEYS = { "a", "aabc", "aac", "acb", "ba", "bab" };
	
	private SymbolTable<String> buildTrieSymbolTable( ) {
		SymbolTable<String> symbolTable = new TrieSymbolTable<>( Alphabets.LowercaseAtoZ );
		Arrays.stream( KEYS ).forEach(  key -> symbolTable.add( key, key ) );
		return symbolTable;
	}
	
	private SymbolTable<String> buildEmptySymbolTable() {
		return new TrieSymbolTable<>( Alphabets.LowercaseAtoZ );
	}
	
	private static List<String> toList( Iterable<String> iterable ){
		return StreamSupport.stream( iterable.spliterator(), false )
							 .collect( Collectors.toList() );
	}
	
	private static String[] toArray( Iterable<String> iterable ){
		return toList(iterable).toArray( new String[]{});
	}
}
	
	

