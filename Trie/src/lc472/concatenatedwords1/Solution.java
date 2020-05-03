package lc472.concatenatedwords1;

import java.util.LinkedList;
import java.util.List;

import trieImplementation.ITrie;
import trieImplementation.Trie;

class Solution {
	ITrie t=new Trie();
	List<String> list=new LinkedList();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	
    	for(String s: words)
    		t.insert(s);
    	
    	for(String word:words){
    		if(isConcat(word,0)){
    			list.add(word);
    		}
    	}
        
    	return list;
    }
	private boolean isConcat(String word,int count) {
		
		if(word.length()==0 && (count>1)) 
			return true;
		if(word.length()==0 && (count<=1)) 
			return false;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<word.length();++i){
			char ch=word.charAt(i);
			sb.append(ch);
			if(t.isWord(sb.toString())){
				count+=1;
				if(isConcat(word.substring(i+1),count)) return true;
				count-=1;
			}			
		}
		return false;
	}
}