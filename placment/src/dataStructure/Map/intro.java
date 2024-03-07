package dataStructure.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class intro {
	public static void main(String[] args) {
		Map<String,Integer> numbers=new HashMap<>();
	    numbers.put("One", 1);
	    numbers.put("Two", 2);
	    numbers.put("Three",3);
	    numbers.put("Four", 4);
	    System.out.println(numbers);
	    numbers.putIfAbsent("Five", 5);
	    System.out.println(numbers.containsKey("Six"));
	
	    
	    Map<String,Integer> number=new TreeMap<>();
	    number.put("One", 1);
	    number.put("Two", 2);
	    number.put("Three",3);
	    number.put("Four", 4);
	
	    number.putIfAbsent("Five", 5);
	    System.out.println(number);
	    System.out.println(number.containsKey("Six"));
//	    String name="hey how you doing";
//	    for(int i=0;i<name.length();i++ ) {
//	    	String word="";
//	    	while(name.charAt(i)!=' ' && i< name.length() ) {
//	    		System.out.println(word+=name.charAt(i));
//	    		i++;
//	    	
//	    	}
//	    	System.out.println(" ");
//	    }
	    
	
	}

}
