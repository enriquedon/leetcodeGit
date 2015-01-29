public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next!=null&&fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) {
		ListNode goal = new ListNode(2);
		ListNode temp = head;
		while (temp != null) {
			if (head.next == goal) {
				return true;
			}
			temp = head.next;
			head.next = goal;
			head = temp;
		}
		return false;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	void append(ListNode a){
		ListNode temp=this;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=a;
	}
}