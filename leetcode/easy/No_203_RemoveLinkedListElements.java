package leetcode.easy;

/**
 * Created by jc on 4/26/2016.
 */

public class No_203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val){
        ListNode tmp=head;
        ListNode before=new ListNode(0);
        ListNode res=before;
        before.next=head;
        while(tmp!=null){
            if(tmp.val==val){
                before.next=tmp.next;

                tmp=tmp.next;
            }else{
                tmp=tmp.next;
                before=before.next;
            }

        }
        return res.next;
    }


    public static void main(String[] args){
        ListNode root=new ListNode(1);
        root.next=new ListNode(1);
//        root.next.next=new ListNode(3);
//        root.next.next.next=new ListNode(4);

        No_203_RemoveLinkedListElements test=new No_203_RemoveLinkedListElements();
        root=test.removeElements(root,1);
        ListNode tmp=root;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
    }
}
