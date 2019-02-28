package os2;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class UI {
    public static void main(String args[]) throws InterruptedException {
    	System.out.println("What is number of Pumps?");
        Scanner in = new Scanner(System.in);
        int pumpnumer = in.nextInt();
        Semaphore sem = new Semaphore(pumpnumer);
    	System.out.println("Number of Clients");
    	int clientnums = in.nextInt();
    	System.out.println("Clients’ names:");
        Scanner instr = new Scanner(System.in);
    	String namestr = instr.nextLine();
    	String clientnames[] = namestr.split(" ");
    	
    	pump[] threads = new pump[clientnums];
    	
		int time;
		Random r = new Random();
    	
    	for(int i=0;i<clientnums;i++){
    		//System.out.println(clientnums);
    		time = r.nextInt(2);		
    	   	try {
    			TimeUnit.SECONDS.sleep(time);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		//threads[i] = new pump(sem,clientnames[i]);
    		threads[i].start();
    	}
    	for(int i=0;i<clientnums;i++){
    		threads[i].join();
    	}


        
        
        
        
    	
    	
    	
    	
    }

}
