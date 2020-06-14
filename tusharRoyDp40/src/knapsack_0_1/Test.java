package knapsack_0_1;

public class Test {

	public static void main(String[] args) {
		
		Solution s=new Solution();
		int W=50;
		int wt[]={10,20,30};
		int val[]={60,100,120};
		int n=val.length;
		int x=s.knapSack(W, wt, val, n);
		System.out.println(x);
		
	}

}
