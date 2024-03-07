package algorithm;


public class LL {

	Node head;
	private int size;

	LL() {
		size = 0;
	}

	public class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
			size++;
		}
	}

	public void addInMiddle(int index, String data) {
		if (index > size || index < 0) {
			System.out.println("Invalid Index value");
			return;
		}
		size++;

		Node newNode = new Node(data);
		if (head == null || index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node currNode = head;
		for (int i = 1; i < size; i++) {
			if (i == index) {
				Node nextNode = currNode.next;
				currNode.next = newNode;
				newNode.next = nextNode;
				break;
			}
			currNode = currNode.next;
		}
	}

	public void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(String data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node lastNode = head;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}

		lastNode.next = newNode;
	}

	public void printList() {
		Node currNode = head;

		while (currNode != null) {
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		System.out.println("null");
	}

	public void removeFirst() {
		if (head == null) {
			System.out.println("Empty List, nothing to delete");
			return;
		}

		head = this.head.next;
		size--;
	}

	public void removeLast() {
		if (head == null) {
			System.out.println("Empty List, nothing to delete");
			return;
		}

		size--;
		if (head.next == null) {
			head = null;
			return;
		}

		Node currNode = head;
		Node lastNode = head.next;
		while (lastNode.next != null) {
			currNode = currNode.next;
			lastNode = lastNode.next;
		}

		currNode.next = null;
	}

	public int getSize() {
		return size;
	}

	public void reverseList() {
		if (head == null || head.next == null) {
			return;
		}
		Node prNode = head;
		Node curNode = head.next;
		while (curNode != null) {
			Node nexNode = curNode.next;
			curNode.next=prNode;
			//update
			prNode = curNode;
			curNode = nexNode;
		}
		head.next = null;
		head = prNode;
	}

	public Node reversRecursiv(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newhead = reversRecursiv(head.next);
		head.next.next = head;
		head.next = null;
		return newhead;

	}

	public static void main(String args[]) {
		LL list = new LL();
		list.addLast("is");
		list.addLast("a");
		list.addLast("list");
		list.addLast("of");
		list.addLast("String");
		list.addLast("DataType");
		//list.printList();

		list.addFirst("this");
		//list.printList();
		//System.out.println(list.getSize());

		// list.removeFirst();
		list.printList();
		list.reverseList();

		//list.removeLast();
		list.printList();
		list.head=list.reversRecursiv(list.head);
		list.printList();
	}
}
