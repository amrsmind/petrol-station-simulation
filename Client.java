package os2;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.awt.Color;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Client extends Thread{
	Semaphore sem;
	String cname; 
	DGUI g;
	 pump[] pumps;
	Client(Semaphore sem, String cname,DGUI g,pump[] pumps){
		super(cname);
		this.sem = sem;
		this.cname = cname;
		this.g = g;
		this.pumps = pumps;
		
	}
	/*public synchronized void arrived(){
		int time;
		if(sem.availablePermits() == 0) {
			System.out.println(cname + " arrived and waiting");
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
		try {
			sem.acquire();
			System.out.println(cname + " arrived");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//System.out.println(cname + " arrived and waiting");
			e.printStackTrace();
		}
		}
		
	}
	public synchronized void Occupied(int i){
		int time;
		Random r = new Random();
		time = r.nextInt(5);		
	   	System.out.println(cname + " Occupied"); //1
	   	try {
			Thread.sleep(time*1000);
	   		//TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void Served(int i) {
		int time;
		Random r = new Random();
		System.out.println(cname + " Being Served"); //2
		time = r.nextInt(5);		
	   	try {
			Thread.sleep(time*1000);
	   		//TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void paying(int i) {
		int time;
		Random r = new Random();
	   	System.out.println(cname + " Paying"); //3
		time = r.nextInt(5);		
	   	try {
			//TimeUnit.SECONDS.sleep(time);
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void Leave(int i) {
	   	System.out.println(cname + " Leave");	//4
	   	sem.notify();
	}
*/



	
	public void run(){
		int time;
		int j=0;
		if(sem.availablePermits() == 0) {
			System.out.println(cname + " arrived and waiting");
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
		try {
			sem.acquire();
		    for (int i=0; i<pumps.length;i++){
		        if(pumps[i].getflag()==0){
		            pumps[i].setflag(1);
		            j=i;
		            break;
		        }
		    }
			
			System.out.println(cname + " arrived");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		Random r = new Random();
		time = r.nextInt(10);
	   	g.myPump.elementAt(j).setBackground(Color.red);
	    g.myPump.elementAt(j).setText("Pump " + Integer.toString(j + 1) +"\n"+ cname+ "\n"+" Occupied \n");
	   	System.out.println(cname + " Occupied"); //1

	    
	   	try {
			//TimeUnit.SECONDS.sleep(time);
	   		Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    g.myPump.elementAt(j).setText("Pump " + Integer.toString(j + 1) +"\n"+ cname+ "\n"+" being served \n");

	   	System.out.println(cname + " Being Served"); //2

		time = r.nextInt(10);		
	   	try {
	   		Thread.sleep(time*1000);
			//TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    g.myPump.elementAt(j).setText("Pump " + Integer.toString(j + 1) +"\n"+ cname+ "\n"+" paying \n");
	   	System.out.println(cname + " Paying"); //3
		time = r.nextInt(10);		
	   	try {
	   		Thread.sleep(time*1000);
			//TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	System.out.println(cname + " Leave");	//4
	    g.myPump.elementAt(j).setText("Pump " + Integer.toString(j + 1) +"\n"+ cname+ "\n"+" leave \n");
	   	g.myPump.elementAt(j).setBackground(Color.yellow);
	   	pumps[j].setflag(0);
	   	sem.release();
		/*synchronized (sem) {
			arrived();
			try {
				sem.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int j=0;
	    for (int i=0; i<pumps.length;i++){
	        if(pumps[i].getflag()==0){
	            pumps[i].setflag(1);
	            j=i;
	            break;
	        }
	    }
	    Occupied(j);
	    Served(j);
	    paying(j);
	    Leave(j);

	    pumps[j].setflag(0);*/
	 	}

}
