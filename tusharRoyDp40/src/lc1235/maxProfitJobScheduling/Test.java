package lc1235.maxProfitJobScheduling;

public class Test {

	public static void main(String[] args) {
		Solution s=new Solution();
		int[] startTime={1,2,3,4,6};
		int[] endTime={3,5,10,6,9};
		int[] profit={20,20,100,70,60};
		int maxProfit=s.jobScheduling(startTime, endTime, profit);
		System.out.println("maxProfit ="+maxProfit);

	}

}
