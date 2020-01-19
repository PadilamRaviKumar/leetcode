package leetcode.correctparanthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CorrectParanthesis {

	int mincount=Integer.MAX_VALUE;
	List l2=new ArrayList();
	HashSet<String> set=new HashSet<String>();
    public List<String> removeInvalidParentheses(String s) {
    	int lt=0;
    	int rt=0;
    	for(int j=0;j<s.length();++j) {
    		if(s.charAt(j)=='(') lt++;
    		if(s.charAt(j)==')') rt++;
    		mincount=Math.abs(rt+lt);
    	}
    	
    	List<String> l=new ArrayList();
    	auxRemoveInvalidParanthses(s,set,0);
    	if(set.size()==0) {
    		l2.add("");
    	return l2;
    	}
    	for(String x:set) {
    		if(x.length()==s.length()-mincount) {
    			l2.add(x);
    		}
    	}
        return l2;
    }

	private void auxRemoveInvalidParanthses(String s, Set<String> set,int count) {
		
		for(int i=0;i<s.length();++i) {
			
			char c=s.charAt(i);
			
				//()())()
				if(checkValid(s)) {
					if (count<mincount) {
						mincount=count;
					}
					set.add(s);
					return;
				}
				if(count>mincount)	 return;
				String tmp=s.substring(0, i) + s.substring(i + 1); 
				int newcount=count+1;
				auxRemoveInvalidParanthses(tmp,set,newcount);
			
		}
		
	}

	private boolean checkValid(String s) {
		
		Stack<Character> st=new Stack();
		for(int i=0;i<s.length();++i){
			char c=s.charAt(i);
			if(c=='(') {
				st.push(c);
			}
			if(c==')') {
				if(st.isEmpty()) return false;
				else
					st.pop();
				
					
			}
		}
		return (st.empty());
		
	}
	
	
}
