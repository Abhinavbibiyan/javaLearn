package dataStructure.Llists;
import java.util.*;
public class splitLLinParts {
	public static ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        List<ListNode> parts = new ArrayList<>();

        while (current != null) {
            length++;
            current = current.next;
        }
        int base_size = length / k, extra = length % k;
        current = head;
        for (int i = 0; i < k; i++) {
            int part_size = base_size + (extra > 0 ? 1 : 0);
            ListNode part_head = null, part_tail = null;
            for (int j = 0; j < part_size; j++){
                if (part_head == null) {
                    part_head = part_tail = current;
                } else {
                    part_tail.next = current;
                    part_tail = part_tail.next;
                }
                if (current != null) {
                    current = current.next;
                }
            }
            if (part_tail != null) {
                part_tail.next = null;
            }
            parts.add(part_head);
            extra = Math.max(extra - 1, 0);
        }
        return parts.toArray(new ListNode[0]);
    }
	static void print(ListNode head) {
		ListNode temp=head;
		while(temp!=null) {
			System.out.print(temp.val+ " ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=new ListNode(6);
		head.next.next.next.next.next.next=new ListNode(7);
		head.next.next.next.next.next.next.next=new ListNode(8);
		head.next.next.next.next.next.next.next.next=new ListNode(9);
		head.next.next.next.next.next.next.next.next.next=new ListNode(10);
		head.next.next.next.next.next.next.next.next.next.next=new ListNode(11);
		head.next.next.next.next.next.next.next.next.next.next.next=new ListNode(12);
		ListNode ans[]=splitListToParts(head,3);
		for(int i=0;i<ans.length;i++)   
			print(ans[i]);
		ArrayList<Integer> al=new ArrayList<>();
		al.add(1);
		al.add(null);
		System.out.println(al);
	} 
}
