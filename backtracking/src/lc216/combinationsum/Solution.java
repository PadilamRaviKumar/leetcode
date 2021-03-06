package lc216.combinationsum;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	List<List<Integer>> list=new LinkedList<List<Integer>>();
	public List<List<Integer>> combinationSum3(int k, int n) {
        
		auxCombination(1,k,n,new LinkedList<Integer>());
		return list;
    }

	private void auxCombination(int start, int k, int sum,List<Integer> l) {
		if((sum==0)&&(k==0)){
            System.out.println(l);
			list.add(new LinkedList(l));
            return;
		}
		if((k==0)&&(sum>0)) return;
		
		for(int i=start;i<=9;++i){	
			if((sum-i)<0) return;
			else{	
			l.add(i);
			auxCombination(i+1, k-1, sum-i,l);
			l.remove(l.size()-1);
			}
		}
		
	}
	
}
