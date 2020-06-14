package lc10.regularexpressionmatching;

public class Test {

	public static void main(String[] args) {
		Solution sol=new Solution();
		String s="aab";
		String p="b.*";		
		boolean flag=sol.isMatch(s, p);
		System.out.println("is Matching = "+flag);

	}

}
