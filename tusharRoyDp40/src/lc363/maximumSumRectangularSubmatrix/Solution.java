package lc363.maximumSumRectangularSubmatrix;

public class Solution {

	public int maxSumSubmatrix(int[][] matrix, int k) {
		int max = Integer.MIN_VALUE;
		int top, bottom, left, right, sum;
		int mem[] = new int[matrix.length];

		for (int start = 0; start < matrix[0].length; ++start) {
			for (int c = start; c < matrix[0].length; ++c) {
				left = c;
				top = 0;
				bottom = matrix.length;
				right = 0;
				for (int r = 0; r < matrix.length; ++r) {
					mem[r] = mem[r] + matrix[r][c];
				}
				int res[] = maxSubArray(mem,k);
				
				if (res!=null && res[0] > max && res[0]<=k) {
					left = start;
					right = c;
					top = res[1];
					bottom = res[2];
					max=res[0];
				}
			}
			//reset
			mem=new int[matrix.length];
		}
		return max;
	}

	private  int[] maxSubArray(int[] nums,int k) {
		if (nums.length==0) return null;
	        int[] mem= new int[nums.length];
	        mem[0]=nums[0];
	        int max=mem[0];
	        int lastIndex=0;
	        int startIndex=0;
	        int glastIndex=0;
	        int gstartIndex=0;
	        int res[]=new int[3];
	        for(int i=1;i<nums.length;++i){
	            if(nums[i]>=(mem[i-1]+nums[i])){
	            	startIndex=i;
	            	lastIndex=i;
	            	mem[i]=nums[i];
	            }
	            else{
	            	mem[i]=(mem[i-1]+nums[i]);
	            	lastIndex++;
	            }
	            //mem[i]=Math.max((mem[i-1]+nums[i]),nums[i]);
	            if(mem[i]>max && mem[i]<=k){
	            	max=Math.max(max,mem[i]);
	            	gstartIndex=startIndex;
	            	glastIndex=lastIndex;	        	            
	            }
	        }
	        res[0]=max;
	        res[1]=gstartIndex;
	        res[2]=glastIndex;
	        return res;
	    }
}
