package lc85.maximalRectangle;

import java.util.Stack;

public class Solution {

	// find height array for each row
	// use maximum histogram area problem
	private int mem[];
	private int maxAreaGlobal=0;
	private int maxArea = 0;
	private Stack<Integer> posStack = new Stack<Integer>();
	private Stack<Integer> valStack = new Stack<Integer>();

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0) return 0;
		mem = new int[matrix[0].length];
		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[r].length; ++c) {
				int val=Character.getNumericValue(matrix[r][c]);
				mem[c]=(val==0)?0:mem[c]+val;
			}
			maxAreaGlobal=Math.max(largestRectangleArea(mem),maxAreaGlobal);
		}
		return maxAreaGlobal;

	}

	private int largestRectangleArea(int[] heights) {
		int i;
		for (i = 0; i < heights.length; ++i) {
			addlargestRectangleArea(i, heights[i]);
		}
		digestStack(i);
		return maxArea;
	}

	private void digestStack(int i) {
		while (true) {
			if (posStack.isEmpty() && valStack.isEmpty())
				break;
			else {
				int val = valStack.pop();
				int pos = posStack.pop();
				maxArea = Math.max((val * (i - pos)), maxArea);
			}
		}
	}

	private void addlargestRectangleArea(int pos, int val) {
		// { 2, 1, 5, 6, 2, 3 };
		while (true) {
			if (posStack.isEmpty() && valStack.isEmpty()) {
				posStack.push(pos);
				valStack.push(val);
				break;
			} else {
				if (valStack.peek() < val) {
					posStack.push(pos);
					valStack.push(val);
					break;
				} else if (valStack.peek() == val) {
					break;
				} else {
					int x = valStack.pop();
					maxArea = Math.max((pos - posStack.peek()) * x, maxArea);
					if (!valStack.isEmpty() && valStack.peek() > val) {
						posStack.pop();
					} else {
						valStack.push(val);
						break;

					}
				}
			}
		}

	}
}
