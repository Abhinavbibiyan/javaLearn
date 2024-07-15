package string;

public class stringintro {
 
	public static void main(String[] args) {
		        String name= "abhinav";
		        String secname= new String("abhinav");           ////  new object ,,,, memory allocate in heap area
		        String name2="abhinav";
//		        System.out.println(name==secname);         /////////  memory allocate in string pool area 
//		        System.out.println(name==name2);           ///string are immutable,,,  not can value,,,,  if we try a new memory location is allocate to that sting;
                String  name3="";
//                System.out.println(name);                  ////1st string remain in memory same,,,,no over write ,,,,bibiyan is assigne to another memory 
//                System.out.println(name.charAt(4));        / //string function
//                System.out.println(name.length());
//                System.out.println(name.substring(3));
//                System.out.println(name.substring(2,6));
//                System.out.println(name.contains("yan"));
//                System.out.println(name==secname);  
//                System.out.println(name.equals(secname)); 
//                System.out.println(name3.isEmpty());
//                System.out.println(name +" bibiyan"); 
//                System.out.println(name.concat("bibiyan")); 
//                System.out.println(secname.replace('a', '@')); 
                String cars="hyundai,maruti,Swift,wagonr,lamborgini,ferrari,";
                String s=cars.replaceAll("[AaeEIiOoUu]", "");
                String allcar[]= s.split(","); 
                for (String item : allcar) {
                	 System.out.print(item +" ");    /////// for each loop
                	                	 
                }
                System.out.println(cars.indexOf('a'));  
                String name5="            good good          ";
                System.out.println(name5.trim());   ////// remove space                
	} 

}
