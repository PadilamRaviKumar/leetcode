package lc312.baloonBurst;
/*
T(i,j) is maximum value obtained by bursting baloons from i to j
suppose we burst baloon k
T(i,j)---> max for k--->i to j {T(i,k-1)+T(k+1,j)+val(k)}*/
public class Solution {

	  public int maxCoins(int[] nums) {
	      if(nums.length==0) return 0;
	      if(nums.length==1) return nums[0];
		  int[][] mem=new int[nums.length+1][nums.length+1];
		  for(int d=0;d<=nums.length;++d){
			  for(int r=1;r<=nums.length-d;++r){
				  int c=r+d;
				  int lmax=Integer.MIN_VALUE;
				  for(int k=r;k<=c;++k){
					  if(r==c){
						  lmax=nums[k-1]*findElement(r-1,nums,true)*findElement(c-1,nums,false);
						  continue;
					  }
					  else if(k-1<r){
						  lmax=Math.max(0+mem[k+1][c]+nums[k-1]*findElement(r-1,nums,true)*findElement(c-1,nums,false),lmax);
						  continue;
					  }
					  else if(k+1>c){
						  lmax=Math.max(mem[r][k-1]+nums[k-1]*findElement(r-1,nums,true)*findElement(c-1,nums,false),lmax);
						  continue;
					  }
					  else{
						  lmax=Math.max(mem[r][k-1]+mem[k+1][c]+nums[k-1]*findElement(r-1,nums,true)*findElement(c-1,nums,false),lmax);
						  continue;
					  }
				  }
				  mem[r][c]=lmax;
			  }
		  }
		  return mem[1][nums.length];
	    }

	private int findElement(int boundary, int[] nums, boolean flag) {
		
		if(flag==true){
			
			if(boundary==0) return 1;
			else return nums[boundary-1];
		}
		else{
			if(boundary==nums.length-1) return 1;
			else return nums[boundary+1];
		}
		
	}

	
}
