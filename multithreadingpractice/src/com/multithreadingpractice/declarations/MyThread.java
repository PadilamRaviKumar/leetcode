package com.multithreadingpractice.declarations;

import java.util.Arrays;

public class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=1;i<=1000;++i){
			
			System.out.println("Good Morning");
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*MyThread t =new MyThread();
		t.start();*/
		int ar[]={1,2,3};
		ar[1]=10;
		System.out.println(Arrays.toString(ar));
		/*for(int i=1;i<=1000;++i){
			System.out.println(" sleep Ravi!!!");
			sleep(1000);
			System.out.println("wake up Ravi!!!");
		}
		System.out.println("executed!!");
	}*/
	}
}
