package lc139.wordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*T(i,j)--->Can the string starting from i to j be split into dictionary words
T(i,j) = 
True if String(i...j) belongs to dictionary
else
	if k-->(i...j)=T(i,k) && T(k+1,j) is True return True
	else return False*/

public class Solution {

	private HashSet<String> lookup = new HashSet<String>();

	public boolean wordBreak(String s, List<String> wordDict) {
		for (String word : wordDict)
			lookup.add(word);
		boolean mem[][] = new boolean[s.length() + 1][s.length() + 1];
		int n = s.length();

		for (int d = 0; d < s.length(); ++d) {
			for (int r = 1; r <= n - d; ++r) {
				int c = r + d;
				String word = s.substring(r - 1, c);
				if (lookup.contains(word)) {
					mem[r][c] = true;
				} else {
					for (int k = r; k < c; ++k) {
						if ((mem[r][k] == true) && (mem[k + 1][c] == true)) {
							mem[r][c] = true;
							break;
						} else {
							mem[r][c] = false;
						}
					}
					
				}
			}

		}
		return mem[1][s.length()];
	}

}
