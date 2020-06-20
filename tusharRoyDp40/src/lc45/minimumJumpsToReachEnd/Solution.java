package lc45.minimumJumpsToReachEnd;

public class Solution {

	public int jump(int[] nums) {
		if(nums.length==0) return 0;
		if(nums.length==1) return 0;
		int mem[]=new int[nums.length+1];
		
		for(int i=2;i<mem.length;++i){
			int min=Integer.MAX_VALUE;
			for(int k=1;k<=i-1;++k){				
				if(nums[k-1]>=Math.abs((i-k))){
					min=Math.min(min, mem[k]);
				}
			}
			mem[i]=min+1;
		}
		return mem[nums.length];
	}
	
/*	leetcode
 * public int jump(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
*/
}
