package com.multithreading.producerconsumer;

public class Consumer extends Thread{

	Resource r;
	public Consumer(Resource r) {
		this.r = r;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			if(r.size()!=0)
				System.out.println(r.remove());
			else{
				//System.out.println("consumed...waiting for next set!!!");
				synchronized (r) {						
						r.notify();
						
					} 
				}
			if(r.count<=0) break;
			}
		}
	}


