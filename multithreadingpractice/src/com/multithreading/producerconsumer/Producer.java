package com.multithreading.producerconsumer;

public class Producer extends Thread {

	Resource r;

	public Producer(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		int num = 1;
		while (r.count > 0) {
			if (r.size() <= 4) {
				r.add(num);
				r.count -= 1;
				num++;
			} else {
				System.out.println("Added set of elements!!!");
				synchronized (r) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
