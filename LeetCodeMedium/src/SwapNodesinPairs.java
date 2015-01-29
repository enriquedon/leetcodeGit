public class SwapNodesinPairs {
	static ListNode previous = null;
	static ListNode returnHead = null;

	public static ListNode swapPairs(ListNode head) {

		// ListNode one = head;
		ListNode tempListNode;
		if (head == null ) {
			return returnHead;
		} else if (head.next == null && returnHead == null) {
			return head;
		}else if(head.next == null){
			return returnHead;
		}

		if (previous == null) {
			returnHead = head.next;
			tempListNode = head.next;
			head.next = head.next.next;
			tempListNode.next = head;
			previous = head;
		} else {
			tempListNode = head.next;
			System.out.println(head.val);

			head.next = head.next.next;

			tempListNode.next = head;
			previous.next = tempListNode;
			previous = head;
		}
		System.out.println("previous:" + previous.val + "temphead:" + head.val
				+ "returnHead:" + returnHead.val);
		return swapPairs(previous.next);
		// return returnHead;

	}

	public static void main(String args[]) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		//ListNode four = new ListNode(4);
		//ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		//three.next = four;
		//four.next = five;
		ListNode cc = swapPairs(one);
		System.out.println(cc.val + "," + cc.next.val + "," + cc.next.next.val
				);
	}
}
