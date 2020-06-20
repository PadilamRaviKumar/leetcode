package lc221.maximalSquare;



public class Test {

	public static void main(String[] args) {
		Solution s=new Solution();
		
		char[][] matrix={{'0'}};
		/*char[][] matrix={{'0','1'},{'1','0'}};*/
		int max=s.maximalSquare(matrix);
		System.out.println("max area = "+max);

	}

}
