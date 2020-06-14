package lc363.maximumSumRectangularSubmatrix;

public class MaxSubArray {
	 public static int[] maxSubArray(int[] nums) {	        	        
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
	            if(mem[i]>max){
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
