package codingInterviewBook.linkedList;

/**
 * Created by jc on 2/17/2017.
 */


public class Problem04_ReverseLinkedList {


    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode prev;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
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

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.prev;
        }
        System.out.println();
    }


    public static Node reverseList(Node head){
        Node pre=null;
        Node next=null;

        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode prev=null;
        DoubleNode next=null;

        while(head!=null){
            next=head.next;
            head.next=prev;
            head.prev=next;
            prev=head;
            head=next;
        }
        return prev;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.prev = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.prev = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.prev = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }
}
