package subsetsum;



public class Test {

	public static void main(String[] args) {
		
			Solution s=new Solution();			
			int set[]={2,3,7,8,10};			
			int sum=11;
			boolean x=s.isSubsetSum(set,set.length , sum);
			System.out.println(x);
		

	}

}
