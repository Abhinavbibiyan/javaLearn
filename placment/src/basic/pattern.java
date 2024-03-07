package basic;
//import java.util.*;
public class pattern {
   public static void main(String args[]) {
       int n = 5;
       int m = 4;
       for(int i=0; i<n; i++) {
           for(int j=0; j<m; j++) {
               if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                   System.out.print(" *");
               } else {
                   System.out.print("  ");
               }
           }
           System.out.println();
       }
           for(int i=n; i>=1; i--) {
               for(int j=1; j<i; j++) {
                   System.out.print("   ");
               }
     
               for(int j=0; j<=n-i; j++) {
                   System.out.print("  *");
               }
               System.out.println();
       }
           for(int i=1; i<=n; i++) {
               for(int j=1; j<=i; j++) {
                   System.out.print(" "+j);
               }
               System.out.println();
           }
           for(int i=n; i>=1; i--) {
               for(int j=1; j<=i; j++) {
                   System.out.print(" "+j);
               }
               System.out.println();
           }
           int number = 1;
           
           for(int i=1; i<=n; i++) {
               for(int j=1; j<=i; j++) {
                   System.out.print(number+" ");
                   number++;
               }
               System.out.println();
           }
           for(int i=1; i<=n; i++) {
               for(int j=1; j<=i; j++) {
                   if((i+j) % 2 == 0) {
                       System.out.print(1+" ");
                   } else {
                       System.out.print(0+" ");
                   }
               }
               System.out.println();
           }
           
   }
}


