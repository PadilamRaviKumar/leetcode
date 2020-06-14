package subsetsum;

public class Solution {
	
	/*T[sum][j]=is it possible to get sum with j elements?
	
			if sum<ar[j]
					T[sum][j]=T[sum][j-1]
			else
				T[sum][j]=T[sum-ar[j]][j-1] or
				T[sum][j]=T[sum][j-1]*/
	boolean isSubsetSum(int set[],int n, int sum) {
		boolean mem[][] = new boolean[sum+1][n + 1];
		for (int i = 0; i < n + 1; ++i) {
			mem[0][i] = true;
		}
		for (int j = 1; j < sum + 1; ++j) {
			mem[j][0] = false;
		}
		for (int i = 1; i < mem.length; ++i) {
			for (int j = 1; j < mem[0].length; ++j) {
				if (set[j-1] > i) {
					mem[i][j] = mem[i][j - 1];
				} else {
					mem[i][j] = (mem[i][j - 1]|| mem[(i - set[j-1])][j-1] );
				}
			}
		}
		return mem[sum][n];
	}
	
}
