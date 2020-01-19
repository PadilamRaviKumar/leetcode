package com.datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

public class CourseScheduling {
		public boolean courseSchedule(int[][] graph) {
			
			int[][] in=makeMatrix(graph);
			int n=in.length;
			int[] visit=new int[n];
			List l=new LinkedList();
			for(int u=0;u<n;++u){
				
				
				 auxCourseSchedule(in,visit,u,l);
				//if(b==false) return false;
			}
			return true;
	        
	    }

		private void auxCourseSchedule(int[][] in, int[] visit, int u, List l) {
			
			visit[u]=1;l.add(u);
			for(int v=0;v<in.length;++v){
				if(in[u][v]==1){
					if(visit[v]==0){						
						 auxCourseSchedule(in, visit, v,l);
					}
					
				}
			}
			
			
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



