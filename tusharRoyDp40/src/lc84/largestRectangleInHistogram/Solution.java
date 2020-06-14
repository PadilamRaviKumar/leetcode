package lc84.largestRectangleInHistogram;

import java.util.Stack;

class Solution {

	private int maxArea = Integer.MIN_VALUE;
	private Stack<Integer> posStack = new Stack<Integer>();
	private Stack<Integer> valStack = new Stack<Integer>();

	public int largestRectangleArea(int[] heights) {
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
//{ 2, 1, 5, 6, 2, 3 };
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
				}
				else if(valStack.peek() == val){
					break;
				}
				else {
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