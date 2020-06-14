package lc322.coinchange;

public class Test {
	public static void main(String[] args) {		
		Solution s=new Solution();
		int[] coins={3,5,10};
		int amount = 7;
		System.out.println(s.coinChange(coins, amount));
	}
}
