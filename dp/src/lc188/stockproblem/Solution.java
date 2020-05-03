package lc188.stockproblem;

class Solution {
    public int maxProfit( int[] prices,int fee) {
    	
        int n=prices.length;
        int k=n;
        if(n==0) return 0;
        if(n==1) return 0;
        int max=Integer.MIN_VALUE;
        int mem[][] =new int[k+1][n+1];
        for(int i=0;i<n+1;++i){
        	mem[0][i]=0;
        }
        for(int i=0;i<k+1;++i){
        	mem[i][0]=0;
        }
        for(int r=1;r<k+1;++r){
        	for(int c=1;c<n+1;c++){
        		int profit1= mem[r][c-1];
        		int profit2=Integer.MIN_VALUE;       		
        		for(int j=1;j<=c;++j){
        			/*if(j-2<=0){
        				profit2=Math.max(0+prices[c-1]-prices[j-1],profit2);
        			}
        			else*/
        			profit2=Math.max(mem[r-1][j]+prices[c-1]-prices[j-1]-fee,profit2);
        		}
        		mem[r][c]=Math.max(profit1, profit2);
        		max=Math.max(mem[r][c], max);
        	}
        }       
    	return max;
    }
}

