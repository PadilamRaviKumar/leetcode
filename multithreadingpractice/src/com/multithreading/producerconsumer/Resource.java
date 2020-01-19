package com.multithreading.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Resource {

	private List<Integer> q= new ArrayList<Integer>(5);
	public int count=11;
	public void add(int x){
		q.add(x);
	}
	public int remove(){
		return q.remove(0);
	}
	public int size(){
		return q.size();
	}
	
	
}
