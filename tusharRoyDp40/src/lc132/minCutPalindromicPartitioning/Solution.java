package lc132.minCutPalindromicPartitioning;

public class Solution {

/*	T(i,j)-->minimum cuts to get palindrome for string s from i to j
	
	if(s(i,j) is palindrome) return 0
	else
		for k-->i..j-1 min{T(i,k) + T(k+1,j)}+1*/
	
	
	    private boolean isPalindrome(String s) {
			int i=0,j=s.length()-1;
			while(i<j) {
				if(s.charAt(i)==s.charAt(j)) {
					i++;
					j--;
				}
				else
					return false;
			}
			return true;
		}

		public int minCut(String s) {
			int n = s.length();
			int[][] mem = new int[n][n];
			for (int i = 0; i < n; ++i)
				mem[i][i] = 0;
			for (int l = 1; l < n; ++l) {
				for (int i = 0; i < n - l; ++i) {
					int j = i + l;
					if (isPalindrome(s.substring(i,j+1)))
						mem[i][j] = 0;
					else {
						int min = Integer.MAX_VALUE;
						for (int k = i; k < j; ++k) {
							int leftcuts = mem[i][k];
							int rightcuts = mem[k + 1][j];
							min = Math.min(min, leftcuts + rightcuts + 1);
						}
						mem[i][j] = min;
					}
				}
			}
			//(mem);
			return mem[0][n - 1];
		}

	}

