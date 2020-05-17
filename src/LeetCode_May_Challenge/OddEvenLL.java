package LeetCode_May_Challenge;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        int val = 1;
        if(head == null) {
            return null;
        }
        ListNode oddCur = null;
        ListNode evenCur = null;
        ListNode evenHead = null;
        ListNode oddHead = null;
        while(head!=null) {
            if(val%2==0) {
                if(evenCur==null)  {
                    evenCur = head;
                    evenHead = head;
                } else {
                    evenCur.next = head;
                    evenCur = evenCur.next;
                }
                    
            } else {
                if(oddCur==null) {
                    oddCur = head;
                    oddHead = head;
                } else {
                    oddCur.next = head;
                    oddCur = oddCur.next;
                }
            }
            head = head.next;
            val++;
        }
        oddCur.next = evenHead;
        if(evenCur!=null) {
            evenCur.next = null;
        }
        return oddHead;
    }
    public static void main(String[] args) {
        OddEvenLL ob = new OddEvenLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))));
        head = null;
        ListNode res = head;
        while(res!=null) {
            System.out.print(res.val);
            res = res.next;
        }
        res = ob.oddEvenList(head);
        while(res!=null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}