package com.oriaxx77.algorythm.graph;

import java.util.stream.IntStream;

public interface Search {

	boolean isConnectedTo(int vertex);

	IntStream getConnectedVertices();

}