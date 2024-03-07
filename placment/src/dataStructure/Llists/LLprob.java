package dataStructure.Llists;
import java.util.LinkedList;
import java.util.Scanner;
public class LLprob {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	System.out.println("no of element in list");
    int N = scan.nextInt();
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = 0; i < N; i++) {
        int value = scan.nextInt();
        list.add(value);
    }
    System.out.println("Perfrom queries on Linked List ");
    int Q = scan.nextInt();
    for (int i = 0; i < Q; i++) {
        String action = scan.next();
        System.out.println("what u want Insertion or deletion");
        if (action.equals("Insert")) {
        	System.out.println("enter the index of element");
            int index = scan.nextInt();
            System.out.println("eneter the value of element ");
            int value = scan.nextInt();
            list.add(index, value);
        } 
        else { // "Delete"
        System.out.println("enter the index of elemwnt to delet ");
            int index = scan.nextInt();
            list.remove(index);
        }
    }
    scan.close();
    
    /* Print our updated Linked List */
    for (Integer num : list) {
        System.out.print(num + " ");
    }
}}
