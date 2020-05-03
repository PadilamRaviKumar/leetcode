package trieImplementation;

import java.util.HashSet;

public class Trie implements ITrie{
	private TSTNode root;
	
	HashSet set =new HashSet();
	class TSTNode {

		TSTNode left;
		TSTNode middle;
		TSTNode right;
		boolean isword;
		char data;

		public TSTNode(char ch) {
			this.data = ch;
		}
	}

	/** Initialize your data structure here. */
	public Trie() {

	}

	/** Inserts a word into the trie. */
	private TSTNode auxAdd(TSTNode current, String key) {
		if (current == null) {
			current = new TSTNode(key.charAt(0));
		}
		if (current.data == key.charAt(0)) {
			if (key.length() > 1) {
				current.middle = auxAdd(current.middle, key.substring(1));
			} else {
				current.isword = true;
				return current;
			}
		} else if (key.charAt(0) < current.data) {
			current.left = auxAdd(current.left, key);
		} else {
			current.right = auxAdd(current.right, key);
		}
		return current;

	}
	
	public void insert(String key) {
		if(key.length()==0) return;
		TSTNode tmp = auxAdd(root, key);
		if (root == null)
			root = tmp;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		boolean flag = false;
		TSTNode root = this.root;
		while (word.length() > 0) {
			char ch = word.charAt(0);
			if (root.data == ch) {
				if (word.length() == 1) {
					if (root.isword)
						flag = true;
				}
				word = word.substring(1);
				root = root.middle;
			}

			else if (ch < root.data) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return flag;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		
		TSTNode lroot=getLastPrefixRoot(prefix, root);
		if(lroot==null) return false;
		auxSearch(lroot,prefix);
		System.out.println(set.size());
		return (set.size()>0);

	}

	private TSTNode getLastPrefixRoot(String prefix, TSTNode root) {
		TSTNode lroot=root;
		while (prefix.length() > 0) {
			if(lroot==null) break;
			char ch = prefix.charAt(0);
			if (lroot.data == ch) {				
				prefix = prefix.substring(1);
				lroot = lroot.middle;
			}
			else if (ch < lroot.data) {
				lroot = lroot.left;
			} else {
				lroot = lroot.right;
			}
		}		
		return lroot;
	}

	private void auxSearch(TSTNode root,String prefix) {
		if(root==null) return;
		if(root.isword) set.add(prefix+root.data);
		auxSearch(root.left,prefix);
		auxSearch(root.middle,prefix+root.data);
		auxSearch(root.right,prefix);
		
	}

	@Override
	public boolean isWord(String word) {
		TSTNode lroot=root;
		TSTNode prev=root;
		while(word.length()>0){
			if(lroot==null) break;
			char ch=word.charAt(0);		
			if (lroot.data == ch) {				
				word = word.substring(1);
				prev=lroot;
				lroot = lroot.middle;
			}
			else if (ch < lroot.data) {
				lroot = lroot.left;
			} else {
				lroot = lroot.right;
			}
		}
		if(word.length()==0){
			return (prev.isword)?true: false;
		}
		return false;
	}
}