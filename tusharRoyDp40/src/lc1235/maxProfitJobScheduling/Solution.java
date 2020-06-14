package lc1235.maxProfitJobScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	private int globalMaxProfit = 0;
	/*
	 * if (doNotOverlap(i,j)) T[i]=max(T[i],T[j]+profit[i]) where 0<=j<=i
	 */

	private Job[] jobArray;

	private class Job implements Comparable<Job> {
		private int startTime;
		private int endTime;
		private int profit;

		Job(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job o) {
			return this.endTime - o.endTime;
		}
	}

	

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		jobArray = new Job[startTime.length];
		for (int i = 0; i < startTime.length; ++i) {
			jobArray[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(jobArray);
		int mem[] = new int[jobArray.length];
		for (int i = 0; i < jobArray.length; ++i) {
			int localMaxProfit = 0;
			for (int j = 0; j < i; ++j) {
				if (jobArray[j].endTime <= jobArray[i].startTime) {
					localMaxProfit = Math.max(localMaxProfit, mem[j]);
				}
				else
					break;
			}
			mem[i] = localMaxProfit+jobArray[i].profit;
			globalMaxProfit = Math.max(mem[i], globalMaxProfit);

		}
		return globalMaxProfit;
	}

}
