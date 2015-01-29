public class IntersectionofTwoLinkedLists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == headB)
			return headA;
		int diff = len(headA) - len(headB);

		ListNode faster = diff > 0 ? headA : headB;
		ListNode slower = diff < 0 ? headA : headB;
		if(diff==0){
			faster=headA;
		}
		diff = Math.abs(diff);
		System.out.println(faster.val);
		System.out.println(slower.val);
		while (diff > 0) {
			faster = faster.next;
		}
		while (faster != slower) {
			faster = faster.next;
			slower = slower.next;
		}
		if(faster==null){
			System.out.println(	"No intersection");
		}else{
			System.out.println(faster.val);
		}
		return faster;
	}

	private static int len(ListNode l) {
		int j = 0;
		for (j = 0; l != null; j++) {
			l = l.next;
		}
		//System.out.println(j);
		return j;
	}

	public static void main(String args[]) {
		ListNode faster=new ListNode(1);
		ListNode slower=new ListNode(2);
		//ListNode faster=new ListNode(1);
		if(getIntersectionNode(faster,slower)==null){
			System.out.println(	"No intersection");
		}
		
	}
}
