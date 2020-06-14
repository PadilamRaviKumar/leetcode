package lc10.regularexpressionmatching;

public class Solution {
	
	/*T[i-1][j-1] if s1(i)==s2(j) 
	s1(i)--pattern s2(j)---string
	if s1(i)==*
		if s1(i-1)!=s2(j) T(i-2,j)
		if s1(i-1)==s2(j) or s1(i-1)== '.'
			T(i,j-1) a* counts for multiple a's
			T(i-1,j) a* counts for single a's
			T(i-2,j) a* counts for 0 a's
	if	s1(i)=='.'
		T(i-1,j-1)*/
	//ippi //p*.
	public boolean isMatch(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	}
	}


