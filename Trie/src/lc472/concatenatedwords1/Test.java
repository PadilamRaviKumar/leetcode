package lc472.concatenatedwords1;

import java.util.List;

import trieImplementation.*;
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
		String[] words4={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		String[] words3={"a","b","ab","abc"};
		String[] words={""};
		List<String> l=s.findAllConcatenatedWordsInADict(words);
		for(String word:l)
			System.out.println(word);
		
	}

}
