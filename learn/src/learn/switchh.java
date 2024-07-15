
package learn;
import java.util.Scanner;
class acc{
    int b;
    String N; 
    int an;
    
    acc(int an,String N,int b){
        this.an = an;
        this.b = b;
        this.N = N;
    }
}

class bnk extends acc {
   bnk(int an, String N, int b){
       super( an,  N,  b);
   }
  public void getBalance(){
       System.out.println("Your balance is " + b );
   }
  public void addBalance(){
      System.out.println("Enter money to be deposited");
       Scanner s =  new Scanner(System.in);
       int i = s.nextInt();
       b = b + i;
       getBalance();
  }
  public void reduceBalance(){
      System.out.println("Enter money to be withdrawn");
      Scanner S = new Scanner(System.in);
      int j = S.nextInt();
      b = b - j;
      getBalance();
  }}

public class switchh {
		    public static void main(String[] args) {
	        char choice='y';
	        bnk x = new bnk(220001,"abc",10000);
	        while(choice=='y'){
	        System.out.println("What do you want to do: Deposit , Withdraw, See Balance,Exit");
	        Scanner z = new Scanner(System.in);
	        String Y = z.nextLine();
	        switch (Y) {
	            case "Deposit":
	            x.addBalance();
	                break;
	            case "Withdraw":
	            x.reduceBalance();
	            case "Balance":
	            x.getBalance();
	            case "Exit":
	            	choice='n';
	            	break;
	            default:
	            System.out.println("Error");
	                break;
	                
	        }}
	}}
	
 
