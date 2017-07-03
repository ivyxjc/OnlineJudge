package xyz.ivyxjc.codingInterviewBook.linkedList;

/**
 * Created by jc on 2/17/2017.
 */


public class Problem05_ReversePartofLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 计数从1 开始
     * 该方法 只需要遍历一次数组, 但是边界条件过多, 容易疏忽, 出错.
     * @param head
     * @param from
     * @param to
     * @return
     */
    public static Node reversePart2(Node head, int from, int to) {

        //链表长度为1或链表为空
        if(head==null||head.next==null){
            return head;
        }

        if(from==to){
            return head;
        }

        Node headCopy=head;

        int fromCopy=from;
        int toCopy=to;

        Node pre=null;
        Node next=null;

        //from所代表的node为first, 前面一个node为firstPrev, 没有则为null.
        Node firstPrev=null;
        Node first=null;

        int count=toCopy-fromCopy;

        while(fromCopy>1){
            if(fromCopy==2){
                firstPrev=head;
            }
            head=head.next;
            fromCopy--;
        }

        first=head;

        while(count>=0&&head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
            count--;
        }
        //此时head为to代表的node的next.
        if(firstPrev!=null){
            firstPrev.next=pre;
            first.next=head;
            return headCopy;
        }else {
            first.next=head;
            return pre;
        }
    }


    /**
     *
     * @param head
     * @param from
     * @param to
     * @return
     */
    public static Node reversePart(Node head, int from, int to) {
        int len=0;
        Node node=head;

        Node fPrev=null;
        Node tPost=null;

        while(node!=null){
            len++;
            if(from-len==1){
                fPrev=node;
            }
            if(len-to==1){
                tPost=node;
            }
            node=node.next;
        }

        if(from>to||from <1||to>len){
            return head;
        }

        node=(fPrev==null?head:fPrev.next);
        Node pre=null;
        Node next=null;

        Node nodeCopy=node;

        while(node!=tPost){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }

        nodeCopy.next=tPost;

        if(fPrev!=null){
            fPrev.next=pre;
            return head;
        }else{
            return pre;
        }

   }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 2, 3);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 1, 2);
        printLinkedList(head);

    }
}
