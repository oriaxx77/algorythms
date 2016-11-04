package com.oriaxx77.algorythm.tries;

import java.util.Optional;

public interface SymbolTable<TValue> {

	Optional<TValue> get(String key);

	void add(String key, TValue value);

	boolean empty();

	boolean contains(String key);

	Iterable<String> keys();

	Iterable<String> keysWithPrefix(String prefix);

	void delete(String key);

}