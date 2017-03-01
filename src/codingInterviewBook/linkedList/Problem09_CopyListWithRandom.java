package codingInterviewBook.linkedList;

/**
 * Created by jc on 2/27/2017.
 */

class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;

    RandomListNode(int x) {
        this.label = x;
    }

//    public RandomListNode(int label){
//        this.label = label;
//        this.random =null;
//    }
//
//    public RandomListNode(int label, RandomListNode next){
//        this.label = label;
//        this.next=next;
//        this.random =null;
//    }
}

public class Problem09_CopyListWithRandom {
    /**
     * @param head 为链表的头结点
     * @return
     */
    public static RandomListNode solution_01(RandomListNode head) {

        if (head == null) {
            return head;
        }
        RandomListNode node = head;

        //printLinkedListWithRandom(head);
        //将1-2-3-4-5 复制成 1-1'-2-2'-3-3'-4-4'-5-5',所有节点的设为null
        while (node != null) {
            RandomListNode next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }


        //将rand正确赋值
        node = head;
        while (node != null) {

            if (node.random != null) {
                node.next.random = node.random.next;
            } else {
                node.next.random = null;
            }
            node = node.next.next;
        }

//        printLinkedListWithRandom(head);

        node = head;
        RandomListNode res = head.next;
        RandomListNode pre = head;
        node = head.next;
        while (node.next != null) {
            pre.next = node.next;
            node.next = node.next.next;
            node = node.next;
            pre = pre.next;
        }
        pre.next = null;

        return res;

    }

    public RandomListNode solution_02(RandomListNode node) {

        return null;
    }

    public static void printLinkedListWithRandom(RandomListNode head) {
        System.out.print("Linked List: ");
        RandomListNode headCopy = head;
        while (head != null) {
            System.out.print(head.hashCode() + " ");
            head = head.next;
        }
        System.out.println();
        head = headCopy;
        while (head != null) {
            if (head.random != null) {
                System.out.println(head.label + " random: " + head.random.hashCode());
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode node_1 = new RandomListNode(1);
        RandomListNode node_2 = new RandomListNode(2);
        RandomListNode node_3 = new RandomListNode(3);
        RandomListNode node_4 = new RandomListNode(4);
        RandomListNode node_5 = new RandomListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = null;
        node_1.random = node_3;
        node_3.random = node_1;

        RandomListNode res = solution_01(node_1);
        printLinkedListWithRandom(res);

    }
}
