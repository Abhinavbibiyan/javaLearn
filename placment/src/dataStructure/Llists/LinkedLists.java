package dataStructure.Llists;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedLists {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	// add first and last 
	public void addFIrst(int data) {
		Node newNode=new Node(data);
	
		if(head==null) {
			head =newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	//add last
	public void addLast(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head =newNode;
			return;
		}
		
		Node currNode=head;
		while(currNode.next!=null) {
			currNode=currNode.next;
		}
		currNode.next=newNode;
	}
	// print
	public void printList() {
		//if(head==null) {System.out.println("List is Empty");
		//return;
		//}
		Node currNode=head;
		while(currNode!=null) {
			System.out.print(currNode.data + "-> ");
			currNode=currNode.next;
			
		}
		System.out.println("null");
		
	}
	//Delete first
	public void deletFirst() {
		if(head==null) {
			System.out.println("the list is empty");
			return;
		}
		head=head.next; 
	}
	// 
	public void deleteLast() {
		if(head==null) {
			System.out.println("the list is empty");
			return;}
		if(head.next==null) {
			head=null;
			return;
		}
		Node secondLast=head;
		Node lastNode=head.next;
		
		while(lastNode.next!=null) {
			lastNode=lastNode.next;
			secondLast=secondLast.next;
		}
		secondLast.next =null;
	}
	public Node reverseK(Node head,int K) {
		if(head==null) {
			return null;
		}
		int count=0;
		Node currNode=head;
		Node nextNode=null;
		Node preNode=null;
		while(currNode!=null && count<K ) {
			
			 nextNode=currNode.next;
			//preNode=reverseK(currNode,K);
			currNode.next=preNode;
			preNode=currNode;
			currNode=nextNode;
			count++;
		}
		if(nextNode!=null) {
			head.next=reverseK(nextNode,K);}
			
		return preNode;
		
	}
	public void reverseList() {
		if(head==null||head.next==null) {
			return;
		}
		
		Node prNode=head;
		Node curNode=head.next;
		while(curNode!=null) {
			Node nexNode = curNode.next;
			curNode.next = prNode;
			prNode=curNode;
			curNode=nexNode;
		}
		head.next=null;
		head=prNode;
	}
	public Node reversRecursiv(Node head) {
		if(head==null||head.next==null) {
			return head;
		}
			Node newhead=reversRecursiv(head.next);
			head.next.next=head;
			head.next=null;
			return newhead;
		
	}
	public void cycle() {
		if(head==null || head.next==null) {
			return;
		}
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=head;
	}
	 
	
	public static void main(String[] args) {
		LinkedLists list = new LinkedLists();
		list.addFIrst(1);
		list.addFIrst(2);
		list.addFIrst(3);
		list.addFIrst(7);
		list.addFIrst(5);
		list.printList();
		System.out.println();
		//list.cycle();
	//	list.printList();
//		list.addLast(4);
//		list.printList();
//		System.out.println();
//		list.reverseList();
//	    list.printList();
//		list.reversRecursiv(list.head);
//		System.out.println();
//		list.printList();
		//Collections.reverse(list);
		list.head=list.reverseK(list.head, 2) ;
		list.printList();
//		LinkedList<Integer> LL=new LinkedList<>();
//		LL.add(1);
//		LL.add(2);
//		LL.add(3);
//		LL.add(4);
//		LL.add(5);
//		 
//	   // Collections.reverse(LL);
//	    System.out.println(LL);
//	    int i=0;
//	    while (!LL.isEmpty()) {
//	    	System.out.println(LL.get(i++));
//	     
//	    }
	}

}
