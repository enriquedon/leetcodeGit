public class SearchInsertPosition {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode j = head;
		while (head != null) {
			while (head.next != null && head.val == head.next.val) {
				head.next = head.next.next;
			}
			head = head.next;
		}

		return j;
	}

}

