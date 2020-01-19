package com.datastructures.graphs;

public class Test {

	public static void main(String[] args) {
		int [][]graph={{1,3}, {0,2}, {1,3}, {0,2}};
		boolean b=new Bipartite().isBipartite(graph);
		System.out.println(b);

	}

}
