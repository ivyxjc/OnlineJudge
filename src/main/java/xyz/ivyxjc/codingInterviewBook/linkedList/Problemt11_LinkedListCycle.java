package xyz.ivyxjc.codingInterviewBook.linkedList;

/**
 * Created by jc on 3/4/2017.
 */



 //Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
  }
}

public class Problemt11_LinkedListCycle {

    //链表是否含有环
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        //0: 无环 ; 1: 有环

        int circleFlag=0;
        while (true){
            if(fast.next==null||fast.next.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                return true;
            }
        }
    }

    //找出链表如环的一个节点
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        //0: 无环 ; 1: 有环

        int circleFlag=0;
        while (true){
            if(fast.next==null||fast.next.next==null){
                circleFlag=0;
                break;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                fast=head;
                circleFlag=1;
                break;
            }
        }
        if(circleFlag==0){
            return null;
        }
        while(true){
            if(fast==slow){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;

        }
    }

    //计算无环的链表长度
    public int listLengthWithoutCycle(ListNode head){
        int res=0;
        while (head!=null){
            head=head.next;
            res+=1;
        }
        return res;
    }

    //计算有环链表的长度.
    public int listLengthWithCycle(ListNode node){
        int res=0;
        ListNode ins=detectCycle(node);
        int flag=-1;
        while (true){
            if(flag==1){
                break;
            }
            if(node==ins){
                flag++;
            }
            res+=1;
        }
        return res;
    }


    /**
     *
     * @param headA
     * @param headB
     * @param aIns A入环的第一个节点
     * @param bIns B入环的第一个节点
     * @return
     */
    public ListNode bothLoop(ListNode headA, ListNode headB,ListNode aIns,ListNode bIns){
        //环内相交
        ListNode aInsCopy=aIns;
        while (true){
            aIns=aIns.next;
            if(aIns==aInsCopy){
                break;
            }
            if(aIns==bIns){
                return aIns;
            }
        }

        //在while循环没有return, 说明并没有在环内相交
        int lenA=listLengthWithCycle(headA);
        int lenB=listLengthWithCycle(headB);
        ListNode a=headA;
        ListNode b=headB;
        if(lenA<lenB){
            a=headB;
            b=headA;
        }
        int diff=Math.abs(lenA-lenB);
        for (int i = 0;  i < diff;  i++) {
            a=a.next;
            if(a==aIns){
                return null;
            }
        }
        while(true){
            if(a==b){
                return a;
            }
            if(a==aIns){
                return null;
            }
            if(b==bIns){
                return null;
            }
            a=a.next;
            b=b.next;
        }
    }

    public ListNode noLoop(ListNode headA, ListNode headB){
        int lenA= listLengthWithoutCycle(headA);
        int lenB= listLengthWithoutCycle(headB);
        System.out.println(lenA);
        System.out.println(lenB);
        ListNode a=headA;
        ListNode b=headB;
        if(lenA<lenB){
            a=headB;
            b=headA;
        }
        int diff=Math.abs(lenA-lenB);
        for (int i = 0;  i < diff;  i++) {
            a=a.next;
        }
        while(true){
            if(a==null||b==null){
                return null;
            }
            if(a==b){
                return a;
            }
            a=a.next;
            b=b.next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }

        ListNode aIns=detectCycle(headA);
        ListNode bIns=detectCycle(headB);


        if (aIns==null&&bIns!=null){
            return null;
        }
        if(aIns!=null&&bIns==null){
            return null;
        }
        //都没有环
        if(aIns==null&&bIns==null){
            return noLoop(headA,headB);
        }
        //都有环
        if(aIns!=null&&bIns!=null){
            return bothLoop(headA,headB,aIns,bIns);
        }
        return null;

    }
    
    public static void main(String[] args){ 
        ListNode node0=new ListNode(0);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        ListNode node9=new ListNode(9);




        ListNode n1=new ListNode(11);
        ListNode n2=new ListNode(12);
        ListNode n3=new ListNode(13);
        ListNode n4=new ListNode(14);
        ListNode n5=new ListNode(15);





        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node3;

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=node4;
        
//        System.out.println(new Problemt11_LinkedListCycle().detectCycle(node0).val);

        System.out.println(new Problemt11_LinkedListCycle().getIntersectionNode(n1,node0).val);
    }
}
