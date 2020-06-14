package lc139.wordBreak;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word= "leetcode";
		String[] dict = {"leet", "code"};
		List<String> dictlist=Arrays.asList(dict);
		Solution s = new Solution();
		boolean flag=s.wordBreak(word, dictlist);
		System.out.println(flag);
	}

}
