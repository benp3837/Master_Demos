package com.revature;

//This Thread will extend Thread in order to override the run() method
//But we could have implemented the Runnable Interface to do the same thing (Check NeglectedThread)
public class CoolThread extends Thread {

	@Override
	public void run() {
		
		for(int i =0; i<10; ++i) {
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			sb.append(" is working..."); 
			
			System.out.println(sb);
			
			//This is only so we can see it running... .sleep() will make the Thread wait in millisecond intervals
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		
		System.out.println("Thread Complete!");
		
	}
}
