package cuttingrod;

import java.util.Arrays;

public class Solution {

/*	n--->length of rod
	j--->array length
	T[n][j]--->maximum profit using n length rod with j variant cuts available
	
	if n<j
	T[n][j]=T[n][j-1]
	else
	T[n][j]=max{T[n-j]][j]+val[j],
			T[n][j-1]}*/
	 int cutRod(int price[], int n){
		
		 int mem[][] = new int[n+1][price.length + 1];
			for (int i = 0; i < price.length + 1; ++i) {
				mem[0][i] = 0;
			}
			for (int j = 1; j < n + 1; ++j) {
				mem[j][0] = 0;
			}
			for (int i = 1; i < mem.length; ++i) {
				for (int j = 1; j < mem[0].length; ++j) {
					if (j > i) {
						mem[i][j] = mem[i][j - 1];
					} else {
						mem[i][j] = Math.max(mem[i][j - 1], mem[(i - j)][j] + price[j-1]);
					}
				}
			}
			
				return mem[n][price.length];
	   }
	}

