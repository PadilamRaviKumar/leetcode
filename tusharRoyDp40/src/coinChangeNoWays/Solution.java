package coinChangeNoWays;

import java.util.Arrays;

public class Solution {

//	1 2 3 5
/*T[j][s]-->minimum coins to get sum s with j denominations
	
	if ar[j]>s T[j][s]=T[j-1][s]
	
	else
		{T[j][s-ar[j]]+
		T[j-1][s]}*/
	
	int minCoins(int[] coins, int amount) {
		Arrays.sort(coins);
		 int mem[][] = new int[amount+1][coins.length + 1];
			for (int i = 0; i < coins.length + 1; ++i) {
				mem[0][i] = 1;
			}
			for (int j = 1; j < amount + 1; ++j) {
				mem[j][0] = 0;
			}
			for (int i = 1; i < mem.length; ++i) {
				for (int j = 1; j < mem[0].length; ++j) {
					if (coins[j-1] > i) {
						mem[i][j] = mem[i][j - 1];
					} else {
						mem[i][j] = mem[i][j - 1]+mem[(i - coins[j-1])][j];
					}
				}
			}
			if(( mem[amount][coins.length])> Integer.MAX_VALUE-200000) return -1;	//leetcode cheat to avoid infinity issue
			else 
				return mem[amount][coins.length];
	}
	
}
