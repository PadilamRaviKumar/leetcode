package lc63.uniquepaths;

class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
    	int[][] paths=new int[m+1][n+1];
    	
    	for(int i=0;i<=m;++i) {
    		paths[i][0]=0;
    	}
    	for(int i=0;i<=n;++i) {
    		paths[0][i]=0;
    	}
    	
    	for(int r=1;r<=m;++r) {
    		for(int c=1;c<=n;++c) {
    			if(((r==1)&&(c==1))&& (obstacleGrid[r-1][c-1]!=1)){
    				paths[r][c]=1;
    				continue;
    			}
    			if(obstacleGrid[r-1][c-1]==1) {
    				paths[r][c]=0;
    			}
    			else
    			paths[r][c]=paths[r-1][c]+paths[r][c-1];
    		}
    	}
		return paths[m][n];
        
    }
}