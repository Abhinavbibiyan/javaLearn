package learn;

import java.util.Scanner;

class operations{
    String s;
    void getString()
    {
      System.out.println("Enter any String ");
      Scanner sc=new Scanner(System.in);
      s=sc.nextLine();
       
     }
       void equal( ){
             System.out.println("Enter other String to compare: ");
             Scanner SC=new Scanner(System.in);
             String s1=SC.nextLine();
             SC.close();
                  if(s.equals(s1)){
                      System.out.println("Both String are equal ");
                 }
                  else 
                      System.out.println("Both String are not equal ");
                 }
                 
       void reverse(){
           String r="";
           for (int i=0; i<s.length(); i++)
           {
             char ch= s.charAt(i); 
              r= ch+ r;  
           }
           System.out.println("Reversed String: "+ r);
}
         String change(){
         String s1=s.toUpperCase();   
         return s1;
       }
}
public class Exp10vi {
  public static void main(String[] args) {
      operations f= new operations();
      f.getString();
      f.equal(); 
      System.out.println("New String after converted to Uppercase "+f.change());
      f.reverse();  
  }
}