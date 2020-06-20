package boxStackingLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	private int gmax = Integer.MIN_VALUE;
	private ArrayList<Box> l = new ArrayList<Box>();

	private class Box implements Comparable<Box> {
		int l, w, h, area;

		public Box(int l, int w, int h) {
			super();
			this.l = l;
			this.w = w;
			this.h = h;
			this.area = l * w;
		}

		@Override
		public int compareTo(Box o) {
			return this.area - o.area;
		}

	}

	public int solve(int[][] A) {

		for (int[] row : A) {
			addToList(l, row);
		}
		Collections.sort(l);
		findLIS(l);
		return gmax;
	}

	private void addToList(ArrayList<Box> l2, int[] row) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int x : row)
			list.add(x);
		for (int i = 0; i < list.size(); ++i) {
			int h = list.remove(i);
			l2.add(new Box(Math.max(list.get(0), list.get(1)), Math.min(list.get(0), list.get(1)), h));
			list.add(i, h);
		}
	}

	private void findLIS(ArrayList<Box> nums) {
		if (nums.size() == 0)
			return;
		int lis[] = new int[nums.size()];
		lis[0] = nums.get(0).h;
		int s = nums.size();
		for (int i = 1; i < s; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j) {
				if ((nums.get(j).l < nums.get(i).l) &&(nums.get(j).w < nums.get(i).w)){
					int tmp = lis[j] + nums.get(i).h;
					max = Math.max(tmp, max);
				}
			}			
				lis[i] = max;
				gmax = Math.max(gmax, max);
			
		}

	}
}
