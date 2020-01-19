package com.multithreadingpractice.declarations;

public class MyIThread implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=1000;++i){			
			System.out.println("Good Morning");
			
		}
	}
	
	public static void main(String[] args) {
		Thread t =new Thread(new MyThread());
		t.start();
		
		for(int i=1;i<=1000;++i){
			System.out.println(" Ravi!!!");
		}
		System.out.println("executed!!");
	}

}
