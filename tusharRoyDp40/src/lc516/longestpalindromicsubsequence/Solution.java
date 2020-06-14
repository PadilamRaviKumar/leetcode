package lc516.longestpalindromicsubsequence;

class Solution {
    public int longestPalindromeSubseq(String s) {
        
    	int lps[][]=new int[s.length()+1][s.length()+1];
    	int m=s.length();
    	int n=m;
    	for(int i=0;i<=m;++i) {
    		lps[i][0]=0;
    		lps[0][i]=0;
    	}
    	
    	
    	for(int i=1;i<=m;++i) {
    		for(int j=1;j<=m;++j) {    			
    			if(s.charAt(i-1)==s.charAt(m-j))
    				lps[i][j]=lps[i-1][j-1]+1;
    			else
    				lps[i][j]=Math.max(lps[i-1][j], lps[i][j-1]);
    			
    		}
    	}
		return lps[m][m];
        // write your code here
    }
    	
    
}