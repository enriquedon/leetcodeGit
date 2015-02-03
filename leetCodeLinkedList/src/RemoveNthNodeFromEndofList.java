import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode tempHead2 = head;
		for (int i = 0; i < n; i++) {
			tempHead2 = tempHead2.next;
		}
		if(tempHead2==null){
			System.out.println("deleting head");
		}
		while (tempHead2 != null) {
			pre = pre.next;
			tempHead2 = tempHead2.next;
		}
		
		pre.next = pre.next.next;
		System.out.println("head:"+head.val);
		while(res.next!=null){
			System.out.println("res.next:"+res.next.val);
			res=res.next;
		}
		return res.next;
	}

	public static void main(String args[]) {
		ListNode res1 = new ListNode(11);
		ListNode res2 = new ListNode(1);
		ListNode res3 = new ListNode(2);
		ListNode res4 = new ListNode(3);
		ListNode res5 = new ListNode(4);
		ListNode res6 = new ListNode(5);
		res1.next=res2;
		res2.next=res3;
		res3.next=res4;
		res4.next=res5;
		res5.next=res6;
//		removeNthFromEnd(res1,6);
		List<Integer> l=new LinkedList();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}