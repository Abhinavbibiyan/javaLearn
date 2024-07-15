package array;

import java.util.Scanner;
import java.util.Vector;
 
	  

public class polynomial {
	public static int[] multiply(int[] x,int[] y){
		 int[] ans=new int[x.length+y.length];
		for(int i =0;i<x.length;i++){
           for(int j =0;j<y.length;j++){
              ans[i+j]+=x[i]*y[j]; 
           }
		}
           return ans;
 } 
	
		
		public static void main(String[] args) {
//			Vector<Integer> v=new Vector<>();
			
			// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			System.out.println("enter size");
			int n = s.nextInt();
			 
			System.out.println("enter cof");
			int coeff1[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff1[i] = s.nextInt();
			}
			
		 
			System.out.println("for 2nd");
			System.out.println("enter size");
			n = s.nextInt();
			 
			System.out.println("enter cof ");
			 int coeff2[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff2[i] = s.nextInt();
			}
			 int[] ans=multiply(coeff1,coeff2);
            
			 for(int e:ans) {
				 
				 System.out.print (e+" ");
			 }
			 
			 

		}

	
}
