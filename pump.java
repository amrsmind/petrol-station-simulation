package os2;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.awt.Color;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class pump extends Thread{
	String name;
	int flag;
	 pump(String name,int flag)
	{
	    this.name=name;
	    this.flag=flag;
	}
	 public void setflag(int flag){this.flag=flag;}
	 public int getflag(){return this.flag;}

}
