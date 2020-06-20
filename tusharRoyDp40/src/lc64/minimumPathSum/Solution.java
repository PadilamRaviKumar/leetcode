package lc64.minimumPathSum;

public class Solution {
	public int minPathSum(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
    	int[][] paths=new int[m+1][n+1];
    	
    	for(int i=0;i<=m;++i) {
    		paths[i][0]=Integer.MAX_VALUE;
    	}
    	for(int i=0;i<=n;++i) {
    		paths[0][i]=Integer.MAX_VALUE;
    	}
    	/*{{1,3,1},
			  {1,5,1},
			  {4,2,1}};*/
    	for(int r=1;r<=m;++r) {
    		for(int c=1;c<=n;++c) {
    			if((r==1)&&(c==1)){
    				paths[r][c]=grid[r-1][c-1];
    				continue;
    			}
    			paths[r][c]=Math.min(paths[r-1][c],paths[r][c-1])+grid[r-1][c-1];
    		}
    	}
		return paths[m][n];
        
    }
}
