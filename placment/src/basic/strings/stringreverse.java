package basic.strings;

import java.util.Scanner;

public class stringreverse {
	 public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder name=	new StringBuilder("Abhinav");
		for(int i=0;i<name.length()/2;i++) {
			int front=i;
			int end=name.length()-1-i;
			char frontchar=name.charAt(front);
			char endchar=name.charAt(end);
			name.setCharAt(front, endchar);
			name.setCharAt(end, frontchar);
			
		}
		System.out.println(name.toString().toUpperCase());
		
	}

	
}
