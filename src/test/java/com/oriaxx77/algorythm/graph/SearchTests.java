package com.oriaxx77.algorythm.graph;

import org.junit.Assert;
import org.junit.Test;

public class SearchTests 
{
	
	
	@Test
	public void test_0IsConnectedTo4_expectTrue()
	{
		Search dfs = new RecursiveDepthFirstSearch( graph(), 
																	   sourceVertex() );
		Assert.assertTrue( dfs.isConnectedTo(4) );
	}
	
	@Test
	public void test0IsConnectedTo3_expectFalse()
	{
		Search dfs = new RecursiveDepthFirstSearch( graph(), 
																	   sourceVertex() );
		Assert.assertFalse( dfs.isConnectedTo(3) );
	}
	
	@Test
	public void testGetConnectedVerticesTo0_expect0_1_2_4()
	{
		Search dfs = new RecursiveDepthFirstSearch( graph(), 
																	   sourceVertex() );
		Assert.assertArrayEquals( new int[]{0, 1, 2, 4}, 
								  dfs.getConnectedVertices().toArray() );
	}

	
	private Graph graph()
	{
		Graph graph = new Graph( 5 );
		graph.addEdge( 0, 1);
		graph.addEdge( 1, 2);
		graph.addEdge( 2, 4);
		graph.addEdge( 4, 0);
		return graph;
	}
	
	private int sourceVertex()
	{
		return 0;
	}
}
