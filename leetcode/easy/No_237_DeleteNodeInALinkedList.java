package leetcode.easy;

/**
 * Created by jc on 4/26/2016.
 */

/**
 * 题目中已经说明删除的元素不是队尾部元素
 * except the tail
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class No_237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
//        ListNode tmp=node.next;
//        while(tmp!=null){
//            node.val=tmp.val;
//            tmp=tmp.next;
//            node=node.next;
//        }
//        node=null;

        if(node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;



    }

    public static void main(String[] args){
        ListNode root=new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);

        No_237_DeleteNodeInALinkedList test=new No_237_DeleteNodeInALinkedList();
        test.deleteNode(root.next.next.next);
        ListNode tmp=root;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
    }
}
