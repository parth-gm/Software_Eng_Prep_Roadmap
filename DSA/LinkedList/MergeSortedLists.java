package leetcode;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode curl1=l1,curl2=l2;

        if(curl1==null && curl2==null)
            return null;

        ListNode head=new ListNode();
        ListNode prev=head;

        while(curl1!=null && curl2!=null){

            if(curl1.val<curl2.val){
                prev.next=curl1;
                curl1=curl1.next;
            }
            else {
                prev.next=curl2;
                curl2=curl2.next;
            }
            prev=prev.next;
        }
        if(curl1==null){
            prev.next=curl2;
        }else {
            prev.next=curl1;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
