 package lists.queue;
import lists.link.linkedlist.Node;
public class myqueue<E> {
	private Node <E> head,rear;
	public void enqueue(E e) {
		Node<E>toAdd=new Node(e);
		if(head==null) {
			head=rear=toAdd;
		    return ;
		}
		rear.next=toAdd;
		rear=rear.next;
		
	}
	public E dequeue() {
		if(head==null) {
			return null;
		}
		Node<E>temp= head;
		head=head.next;
		return temp.Data;
		
		
		
	}
	
	
	
	

}
