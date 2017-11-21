package com.oriaxx77.algorythm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.oriaxx77.algorythm.util.Numbers;

public class Graph 
{
	private int size;
	private List<Integer>[] adjacentVertices;

	@SuppressWarnings("unchecked") // Creation of the adjacencies. That is an array of List<Integer>.
	public Graph(int numberOfVertices) 
	{
		Numbers.requirePositive(numberOfVertices);
		this.size = numberOfVertices;
		this.adjacentVertices = new ArrayList[numberOfVertices];
		IntStream.range(0, numberOfVertices ).forEach( i -> adjacentVertices[i] = new ArrayList<Integer>());
		
	}

	public void addEdge(int vertex1, int vertex2) 
	{
		validateVertex(vertex1);
		validateVertex(vertex2);
		
		if (vertex1 != vertex2) 
		{
			if (!adjacentVertices[vertex1].contains(vertex2))
				adjacentVertices[vertex1].add(vertex2);
		
			if (!adjacentVertices[vertex2].contains(vertex1))
				adjacentVertices[vertex2].add(vertex1);
		}
	}

	public Stream<Integer> getAdjacents(int vertex) 
	{
		validateVertex(vertex);
		return adjacentVertices[vertex].stream();
	}

	public int getSize() 
	{
		return size;
	}

	private void validateVertex(int vertex) 
	{
		if (vertex < 0 && vertex >= size)
			throw new RuntimeException("Invalid vertex.");
	}

}
