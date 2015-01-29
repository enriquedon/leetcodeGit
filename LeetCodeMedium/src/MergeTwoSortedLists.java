public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode temp=head;
		while (true) {

			if (l1 == null) {
				temp.next = l2;
				break;
			}
			if (l2 == null) {
				temp.next = l1;
				break;
			}
			System.out.println(temp.val + "," + l1.val + "," + l2.val);
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		return head;
	}

	static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

	    if(null == l1) return l2;
	    if(null == l2) return l1;

	    ListNode head=null;    // head of the list to return

	    // find first element (can use dummy node to put this part inside of the loop)
	    if(l1.val < l2.val)       { head = l1; l1 = l1.next; }
	    else                        { head = l2; l2 = l2.next; }

	    ListNode p = head;     // pointer to form new list

	    // I use && to remove extra IF from the loop
	    while(l1!=null && l2!=null ){
	        if(l1.val < l2.val)   { p.next = l1; l1 = l1.next; }
	        else                    { p.next = l2; l2 = l2.next; }
	        p=p.next;
	    }

	    // add the rest of the tail, done!
	    if(l1!=null )  p.next=l1;
	    else    p.next=l2;

	    return head;
	}
	
	public static void main(String args[]) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.append(new ListNode(2));
		l2.append(new ListNode(4));
		l1.append(new ListNode(8));
		ListNode head;
		head = mergeTwoLists2(l1, l2);
		while (head != null) {
			System.out.print(head.val+",");
			head=head.next;
		}
	}
}
