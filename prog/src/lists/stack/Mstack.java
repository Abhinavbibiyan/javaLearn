package lists.stack;

public class Mstack {

	public static void main(String[] args) throws Exception {
		 mystack<Integer> s= new mystack<>();
		 for(int i=1;i<10;i++) {
	   	     s.push(i);
		}
			int popped=s.pop();
			System.out.println(popped);
			int popp=s.pop();
			System.out.println(popp);//in empty stack pop function produce an empty stack error
			int peek = s.peek();
			System.out.println(peek);
	}

}
 