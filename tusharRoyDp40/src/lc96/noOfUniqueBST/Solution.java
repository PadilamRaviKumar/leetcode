package lc96.noOfUniqueBST;

public class Solution {
	public int numTrees(int m) {

		int[] ways = new int[m + 1];

		ways[0] = 1;
		ways[1] = 1;
		

		for (int n = 2; n <= m; ++n) {
			int s = 0;
			for (int i = 1; i <= n; ++i) {
				s += ways[i - 1] * ways[n - i];
			}
			ways[n] = s;
		}

		return ways[m];

	}
}