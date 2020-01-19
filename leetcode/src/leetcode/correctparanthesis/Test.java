package leetcode.correctparanthesis;

import java.util.List;

public class Test {

	public static void main(String[] args) {
	List<String> al=	new CorrectParanthesis().removeInvalidParentheses("()(((((((()");
	
	for(String s: al){
		System.out.println(s);
	}
	}

}
