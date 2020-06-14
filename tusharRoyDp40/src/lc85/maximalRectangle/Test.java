package lc85.maximalRectangle;

public class Test {

	public static void main(String[] args) {
		
		Solution s=new Solution();
		
		/*char[][] matrix={{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}};*/
		char[][] matrix={{'0','1'},{'1','0'}};
		int max=s.maximalRectangle(matrix);
		System.out.println("max area = "+max);

	}

}
