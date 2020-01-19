package com.multithreading.producerconsumer;

public class Test {

	public static void main(String[] args) {
		Resource r=new Resource();
		Producer p =new Producer(r);
		Consumer c=new Consumer(r);
		p.start();
		c.start();
		Object o=new Object();
		

	}

}
