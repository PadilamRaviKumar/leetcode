package knapsack_0_1;

public class Solution {

	public int knapSack(int W, int wt[], int val[], int n) {

		int mem[][] = new int[W + 1][n + 1];
		for (int i = 0; i < n + 1; ++i) {
			mem[0][i] = 0;
		}
		for (int j = 0; j < W + 1; ++j) {
			mem[j][0] = 0;
		}
		for (int i = 1; i < mem.length; ++i) {
			for (int j = 1; j < mem[0].length; ++j) {
				if (wt[j-1] > i) {
					mem[i][j] = mem[i][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i][j - 1], mem[(i - wt[j-1])][j-1] + val[j-1]);
				}
			}
		}
		return mem[W][n];
	}
}
