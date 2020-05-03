package lc140.concatenatedwords2;

import java.util.Arrays;
import java.util.List;


import trieImplementation.Trie;

public class Test {

	public static void main(String[] args) {
		Trie trie = new Trie();

		/*		trie.insert("apple");
				trie.insert("ape");
				trie.insert("app");
				trie.insert("ant");
				trie.insert("apex");
				System.out.println(trie.search("apple"));   // returns true
				System.out.println(trie.search("app"));     // returns false
				System.out.println(trie.startsWith("a")); // returns true
				trie.insert("app");   
				System.out.println(trie.search("app"));     // returns true
		*/	
				Solution s =new Solution();
				String[] wordDict={"cat", "cats", "and", "sand", "dog"};
				String word="catsanddog";
				//String[] words3={"a","b","ab","abc"};
				//String[] words={""};
				List words=Arrays.asList(wordDict);
				List<String> l=s.wordBreak(word, words);
				for(String w:l)
					System.out.println(w);
				
			}


	}


