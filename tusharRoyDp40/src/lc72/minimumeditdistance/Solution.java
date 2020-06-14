package lc72.minimumeditdistance;

class Solution {
    public int minDistance(String word1, String word2) {
    	
    	int r=word1.length()+1;
    	int c=word2.length()+1;
    	
    	int mem[][]=new int[r][c];
    	for(int i=0;i<r;++i) {
    		mem[i][0]=i;
    	}
    	for(int j=0;j<c;++j) {
    		mem[0][j]=j;
    	}
    	for(int i=1;i<r;++i) {
    		for(int j=1;j<c;++j) {
    			
    			if(word1.charAt(i-1)==word2.charAt(j-1)) {
    				mem[i][j]=mem[i-1][j-1];
    			}
    			else {
    				mem[i][j]=Math.min(Math.min(mem[i-1][j], mem[i-1][j-1]), mem[i][j-1])+1;
    			}
    		}
    	}
		return mem[r-1][c-1];
  
    }
}
