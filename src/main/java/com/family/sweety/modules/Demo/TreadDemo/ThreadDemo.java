package com.family.sweety.modules.Demo.TreadDemo;

class ThreadDemo1 implements Runnable {
private String name;
	
	
	
	public ThreadDemo1(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
	 for(int i =0;i<20;i++){
		 
		 System.out.println(Thread.currentThread().getName()+"线程 :"+i+"名字:"+name);
		 if(i==10){
			 
			 Thread.yield();
			 System.out.println(Thread.currentThread().getName()+"线程 :"+"我先睡会"); 
		 }
		 try {
			 Thread.sleep((int) Math.random());
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
	 }
		
	 System.out.println(Thread.currentThread().getName()+"线程 :"+"结束"+"名字:"+name);
	}

}	
	
public class ThreadDemo{
		public static void main(String[] args) {
			System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
			System.out.println(Thread.currentThread().getPriority()+"主线程运行权值!");
		ThreadDemo1 threadDemo1 = new ThreadDemo1("较高权限线程1");
		ThreadDemo1 threadDemo2 = new ThreadDemo1("较低二");
		Thread thread = new Thread(threadDemo1);
		thread.setPriority(7);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(threadDemo2)	.start();
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");	
	}
		
	}
	

