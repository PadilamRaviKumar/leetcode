package lc300.longestincreasingsubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
    	if(nums.length==0) return 0;
    	int lis[]=new int[nums.length];
    	int s=nums.length;
    	for(int i=0;i<s;++i) {
    		int max=Integer.MIN_VALUE;
    		for(int j=0;j<i;++j) {
    			
    			if(nums[j]<nums[i]) {
    				int tmp=lis[j]+1;
    				max=Math.max(tmp, max);
    			}
    			
    		}
    		if (max==Integer.MIN_VALUE) {
				lis[i]=1;
			}
			else
				lis[i]=max;
    	}
    	int max=Integer.MIN_VALUE;
    	for(int y:lis) {
    		max=Math.max(y, max);
    	}
		return max;
        
    }
}