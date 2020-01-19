package lc26.removeduplicates;

import java.util.Arrays;

public class RemoveDuplicates {
	 public int removeDuplicates(int[] nums) {
	    	//1,1,2,3 1,2,2,3
	    int ptr1=0,ptr2=1;
	    if(nums.length==1) return 1;
	    while(ptr2<nums.length){
	    	
	    	if(nums[ptr1]!=nums[ptr2]){
	    		ptr1++;ptr2++;
	    	}
	    	else{
	    		while(nums[ptr2]==nums[ptr1]){
	    			ptr2++;
	    			if(ptr2==nums.length) break;
	    		}
	    		if(ptr2!=nums.length){
	    		nums[ptr1+1]=nums[ptr2];
	    		ptr1++;
	    	}
	    		else{
	    			System.out.println(Arrays.toString(nums));
	    			return ptr1+1;
	    		}
	    	}
	    }
	    System.out.println(Arrays.toString(nums));
	    	 return (ptr1!=0)?ptr1+1:ptr1;
	        
	    }
}
