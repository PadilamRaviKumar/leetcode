package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> al;
    int index=0;
    /** Initialize your data structure here. */
    public RandomizedSet() {
       this.map=new HashMap();
        this.al=new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(!map.containsKey(val)){
        al.add(val);
        map.put(val,index);
        index++;
        return true;
    	}
    	return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
        al.remove(map.get(val));
        map.remove(val);
            index--;
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r=new Random();
        int ptr=r.nextInt(index);
        return al.get(ptr);
    }
}
