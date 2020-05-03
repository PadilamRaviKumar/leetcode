package lc334.increasingtriplet;

class Solution {
	 public boolean increasingTriplet(int[] nums) {
    	boolean flag=false;
    	if(nums.length==0) return flag;
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
    	
    	for(int y:lis) {
    		if (y==3) {flag=true;
    		break;
    		}
    	}
		return flag;
        
    }
}