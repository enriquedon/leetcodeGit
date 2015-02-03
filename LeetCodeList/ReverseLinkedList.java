
public class ReverseLinkedList {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode preStart=new ListNode(1);
        ListNode res=new ListNode(1);
        preStart.next=head;
        res=preStart;
        ListNode start=head;
        ListNode end=new ListNode(1);
        ListNode cur=new ListNode(1);
        int i=1;
        for(i=1;i<m;i++){
            preStart=preStart.next;
            start=start.next;
        }
        cur=start.next;
        while(cur!=null&&i<n){
            ListNode temp=cur.next;
            cur.next=start;
            start=cur;
            cur=temp;
            i++;
            
        }
        end=preStart.next;
        preStart.next=start;
        
        end.next=cur;
        //if(m==1) return preStart.next;
        return res.next;
        
    }
	
	public static void main(String args[]) {
		ListNode one=new ListNode(1);
		ListNode two=new ListNode(2);
		ListNode three=new ListNode(3);
		one.next=two;
		two.next=three;
		//ListNode faster=new ListNode(1);
		if(reverseBetween(one,2,3)==null){
			System.out.println(	"No intersection");
		}
		
	}
}
