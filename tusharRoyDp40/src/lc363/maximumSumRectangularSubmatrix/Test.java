package lc363.maximumSumRectangularSubmatrix;

public class Test {

	public static void main(String[] args) {
		//int nums[]={-2,1,-3,4,-1,2,1,-5,4};
		//int[] res=new MaxSubArray().maxSubArray(nums);
		
		Solution s=new Solution();
		//int matrix[][]={{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};
//		/int matrix[][]={{1,0,1},{0,-2,3}};
		int matrix[][]={{2,2,-1}};
		//int matrix[][]= {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};				
		int max=s.maxSumSubmatrix(matrix,3);
		System.out.println(max);
	}

}
