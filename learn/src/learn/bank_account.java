//Program to design a class account using inheritance and static that show all function of bank (withdrawl , deposit)

package learn;
import java.util.Scanner;
class account {
	int acc_no;
	String name;
	int balance;
	public account(int acc_no, String name, int balance) {
		this.acc_no = acc_no;
		this.name = name;
		this.balance = balance;
	}
}
 class bank extends account {
	public bank(int a,String b,int c){
    super(a,b,c);
    }
        public void withdraw(int amount){ 
        	if(balance<amount){
          System.out.println("operation no possible");
                       }
        	else {
        		balance=balance-amount;
           System.out.println("opreation completed ::))  Remaining amount is = "+ balance );
        	}}
        public void diposit(int amount) {
        	balance=balance+amount;
        	 System.out.println("opreation completed ::))  now current balance amount is = "+( balance ));
                   }
        public void detail() {
        	System.out.println("acc no = "+ acc_no);
        	System.out.println("bank holder name "+ name);
        	System.out.println("balance amount "+balance);
        }
   }
public class bank_account {
	public static void main(String[] args) {
      bank b=new bank(9092001,"Rohan Khana",10000);
      b.diposit(20000);
      b.withdraw(5000);
      b.detail();
        }
}
