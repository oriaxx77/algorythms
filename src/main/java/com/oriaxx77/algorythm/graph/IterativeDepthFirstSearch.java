package com.oriaxx77.algorythm.graph;

import java.util.stream.IntStream;

// TODO:implement it.
public class IterativeDepthFirstSearch implements Search 
{
	
	private boolean[] connected;
	
	public IterativeDepthFirstSearch( Graph graph, int vertex ) 
	{
		connected = new boolean[graph.getSize()];
		throw new RuntimeException( "Not implemented" );
	}
	
	
	
	@Override
	public boolean isConnectedTo(int vertex) 
	{
		
		return false;
	}

	@Override
	public IntStream getConnectedVertices() 
	{
		
		return null;
	}

}
