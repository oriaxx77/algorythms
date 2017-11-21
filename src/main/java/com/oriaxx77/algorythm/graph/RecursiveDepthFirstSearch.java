package com.oriaxx77.algorythm.graph;

import java.util.stream.IntStream;

public class RecursiveDepthFirstSearch implements Search 
{

	private boolean[] connected;
	
	public RecursiveDepthFirstSearch( Graph graph,
							  		  int sourceVertex )
	{
		
		connected = new boolean[ graph.getSize() ];	
		dfs( graph, sourceVertex );
	}
	
	private void dfs( Graph graph, int sourceVertex )
	{
		connected[ sourceVertex ] = true;
		graph.getAdjacents( sourceVertex ).filter( w -> !connected[w] )
					.forEach( w -> dfs(graph,w) );;
	}
	
	@Override
	public boolean isConnectedTo( int vertex ) 
	{
		return connected[vertex]; 
	}
	
	@Override
	public IntStream getConnectedVertices()
	{
		return IntStream.range(0, connected.length)
						.filter( i -> connected[i]);
	}

}
