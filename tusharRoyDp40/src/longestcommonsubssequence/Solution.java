package longestcommonsubssequence;


/*abcdaf
acbcf*/
	
	public class Solution {

		public int longestCommonSubsequence(String text1, String text2){
			int m=text1.length();
			int n=text2.length();
			int mem[][] = new int[m + 1][n + 1];
			for (int i = 0; i < n + 1; ++i) {
				mem[0][i] = 0;
			}
			for (int j = 0; j < m + 1; ++j) {
				mem[j][0] = 0;
			}
			for (int i = 1; i < mem.length; ++i) {
				for (int j = 1; j < mem[0].length; ++j) {
					if (text1.charAt(i-1)==text2.charAt(j-1)) {
						mem[i][j] = mem[i-1][j - 1]+1;
					} else {
						mem[i][j] = Math.max(mem[i][j - 1], mem[i-1][j]);
					}
				}
			}
			return mem[m][n];
		}
	}

	

