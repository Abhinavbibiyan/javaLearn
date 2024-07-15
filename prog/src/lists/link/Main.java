package lists.link;

 

public class Main {

	public static void main(String[] args) {
	 
		
		linkedlist<Integer> ll= new linkedlist<>();
		ll.add(12);
		ll.add(50);
		ll.add(15);
        ll.add(20);
        ll.add(22);
        ll.add(25);
        ll.print();
       for(int i=1;i<10;i++) {
    	   ll.add(i*5);
       }
       ll.print();
       System.out.println();
       
       linkedlist<String> ll1= new linkedlist<>();
//		ll.add(12);
//		ll.add(50);
//		ll.add(15);
//       ll.add(20);
//       ll.add(22);
//       ll.add(25);
       
      for(int i=1;i<10;i++) {
   	   ll1.add(i*5+" Added ");
      }
      ll1.print();
	}

}
