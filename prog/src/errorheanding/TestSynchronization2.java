package errorheanding;
class Table1{  
	 synchronized void printTable(int n){//synchronized method  
	   for(int i=1;i<=5;i++){  
	     System.out.println(n*i);  
	     try{  
	      Thread.sleep(400);  
	     }catch(Exception e){System.out.println(e);}  
	   }  
	  
	 }  
	}  
	  
	class MyThread1a extends Thread{  
	Table1 t;  
	MyThread1a(Table1 t){  
	this.t=t;  
	}  
	public void run(){  
	t.printTable(5);  
	}  
	  
	}  
	class MyThread2a extends Thread{  
	Table1 t;  
	MyThread2a(Table1 t){  
	this.t=t;  
	}  
	public void run(){  
	t.printTable(100);  
	}  
	}  
	  
	public class TestSynchronization2{  
	public static void main(String args[]){  
	Table1 obj = new Table1();//only one object  
	MyThread1a t1=new MyThread1a(obj);  
	MyThread2a t2=new MyThread2a(obj);  
	t1.start();  
	t2.start();  
	}  
	}  
