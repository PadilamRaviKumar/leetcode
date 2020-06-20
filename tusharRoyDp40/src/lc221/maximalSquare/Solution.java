package lc221.maximalSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
    	
    	int max=Integer.MIN_VALUE;
    	if ((matrix== null)||(matrix.length==0)) return 0;
    	int m=matrix.length;
    	int n=matrix[0].length;
    	int mem[][]=new int[m+1][n+1];
    	
    	for(int r=1;r<m+1;++r){    		
    		for(int c=1;c<n+1;++c){
    			if(matrix[r-1][c-1]=='1'){
    				mem[r][c]=Math.min(Math.min(mem[r][c-1],mem[r-1][c-1]),mem[r-1][c])+1;
    				max=Math.max(max, mem[r][c]);
    			}
    			else{
    				mem[r][c]=0;
    			}
    		}
    	}
        
    	return max*max;
    }
}
