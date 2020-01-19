package com.datastructures.graphs;

public class Bipartite {
	public boolean isBipartite(int[][] graph) {
		
		int[][] in=makeMatrix(graph);
		int n=in.length;
		int[] visit=new int[n];
		for(int u=0;u<n;++u){
			
			visit[u]=1;
			boolean b= auxIsBipartite(in,visit,1,u);
			if(b==false) return false;
		}
		return true;
        
    }

	private boolean auxIsBipartite(int[][] in, int[] visit, int groupId, int u) {
		
		for(int v=0;v<in.length;++v){
			if(in[u][v]==1){
				if(visit[v]==0){
					visit[v]=3-groupId;
					return auxIsBipartite(in, visit, 3-groupId, v);
				}
				else{
					if(visit[v]==groupId) return false;
				}
			}
		}
		return true;
		
	}

	private int[][] makeMatrix(int[][] graph) {
		int rmax=Integer.MIN_VALUE;
		int cmax=Integer.MIN_VALUE;
		for(int[] r:graph){
			rmax=(rmax>r[0])?rmax:r[0];
			cmax=(cmax>r[1])?cmax:r[1];
		}
		int max=Math.max(rmax, cmax);
		int[][] in=new int[max+1][max+1];
		for(int[] r:graph){
			int i=r[0];
			int j=r[1];
			in[i][j]=1; 
		}
		return in;
	}
}

