package lc140.concatenatedwords2;

import java.util.LinkedList;
import java.util.List;

import trieImplementation.Trie;

class Solution {
	Trie t=new Trie();
	List<String> glist=new LinkedList<String>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        for(String word: wordDict)
        t.insert(word);
    	boolean flag=auxFindSentence(s,0,new LinkedList());
    	return  glist;
    }

	private boolean auxFindSentence(String word,int count,LinkedList<String> list) {
		
		if(word.length()==0 && (count>=1)) {
			StringBuffer sb1=new StringBuffer();
			for(String s:list){
				sb1.append(s+" ");				
			}
			glist.add(sb1.toString().trim());
			return true;
		}			
		if(word.length()==0 && (count<1)) {			
			return false;
			}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<word.length();++i){
			char ch=word.charAt(i);
			sb.append(ch);
			if(t.isWord(sb.toString())){
				count+=1;
				list.add(sb.toString());
				auxFindSentence(word.substring(i+1),count,list);
				count-=1;
				list.remove(list.size()-1);
			}			
		}
		return false;
	}
}