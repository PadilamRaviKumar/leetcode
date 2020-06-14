package maximumProfitByBuyingAndSellingNStocks;

public class Solution {

	/*
	T(n,k)--->maximum profit with k transactions and n days
	
	T(n,k)= max{T(n-1,k),
			max[j-->1...n]T(j-1,k-1)+ar[n]-ar[j]}*/
	
	public int maxProfit(int k, int[] prices) {
	       int row = prices.length+1;
	       int col = k+1;
	       int[][] dp = new int[row][col];
	       
	       
	       
	       int maxProfit=0,profit1=0,profit2=0;
	       for(int i=0;i<row;i++){
	           dp[i][0] =0;
	       }
	       for(int i=0;i<col;i++){
	           dp[0][i] =0;
	       }
	       
	       for(int i=1;i<row;i++){
	           for(int j=1;j<col;j++){
	               profit1 = dp[i-1][j];
	               profit2=Integer.MIN_VALUE;
	               for(int it=1;it<i;it++){ //iterate from 0th index of prices to i-1th index
	                   int temp = prices[i-1]-prices[it-1] + dp[it][j-1];                
	                   profit2 = Math.max(profit2,temp);                  
	               }
	               maxProfit=Math.max(profit1,profit2);
	               
	               dp[i][j] = maxProfit;
	           }
	       }
	       
	       
	       return dp[row-1][col-1];
	   }
}
