package lc84.largestRectangleInHistogram;

public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		int heights[] = { 2, 1, 5, 6, 2, 3 };
		int output=s.largestRectangleArea(heights);
		System.out.println("Max Area = "+output);

	}

}
