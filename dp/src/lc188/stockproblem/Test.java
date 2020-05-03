package lc188.stockproblem;

public class Test {

	public static void main(String[] args) {
		int prices[] = {
				2,4,1,8};
		Solution s =new Solution();
		int x=s.maxProfit(prices,2);
		System.out.println(x);
	}
}
