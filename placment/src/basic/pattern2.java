package basic;

import java.util.*;

public class pattern2 {
  public static void main(String args[]) {
      int n = 4;

      //upper part
      for(int i=1; i<=n; i++) {
          for(int j=1; j<=i; j++) {
              System.out.print("ABHINAV ");
          }

          int spaces = 2 * (n-i);
          for(int j=1; j<=spaces; j++) {
              System.out.print("        ");
          }

          for(int j=1; j<=i; j++) {
              System.out.print("ABHINAV ");
          }
          System.out.println();
      }



  //lower part
  for(int i=n; i>=1; i--) {
      for(int j=1; j<=i; j++) {
          System.out.print("ABHINAV ");
      }

      int spaces = 2 * (n-i);
      for(int j=1; j<=spaces; j++) {
          System.out.print("        ");
      }

      for(int j=1; j<=i; j++) {
          System.out.print("ABHINAV ");
      }
      System.out.println();
  }
}   
}

