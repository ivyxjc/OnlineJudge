package codingInterviewBook.stack;

import codingInterviewBook.Util;

import java.util.Stack;

/**
 * Created by jc on 2/17/2017.
 */

class Node{

    public int value;

    public Node left;

    public Node right;

    public Node(int data){
        this.value=data;
    }

    @Override
    public String toString() {
        return "label: "+value;
    }
}

public class Problem08_MaxTree {


    public  static Node getMaxTree(int [] arr){
        int [] left=getCompStack(arr);
        int [] arrReverse=reverseArray(arr);
        int [] right=getCompStack(arrReverse);
        right=reverseArrayAndIndex(right);
        Util.printArray(left);
        Util.printArray(right);

        Node[] nodeArr=new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodeArr[i]=new Node(arr[i]);
        }

        Node head=null;

        for (int i = 0; i < arr.length; i++) {
            if(left[i]==-1&&right[i]==-1){
                head=nodeArr[i];
                continue;
            }
            int min=-1;

            if(left[i]==-1||right[i]==-1){
                min=(left[i]==-1?right[i]:left[i]);
            }else{
                min=(arr[left[i]]>arr[right[i]]?right[i]:left[i]);
            }

            if(nodeArr[min].left==null){
                nodeArr[min].left=nodeArr[i];
            }else {
                nodeArr[min].right=nodeArr[i];
            }
        }

        return head ;
    }

    public static int[] reverseArrayAndIndex(int[] arr){
        arr=reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                continue;
            }
            arr[i]=arr.length-1-arr[i];
        }
        return arr;
    }

    public static int[] reverseArray(int  [] arr){
        int [] arrReverse=new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--){
            arrReverse[i]=arr[arr.length-i-1];
        }
        return arrReverse;
    }

    public static int[] getCompStack(int[] arr) {
        Stack<Integer> compStack = new Stack<>();

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!compStack.isEmpty() && arr[compStack.peek()] < arr[i]) {
                compStack.pop();
            }

            if (compStack.isEmpty()) {
                res[i] = -1;
                compStack.push(i);
                continue;
            }

            if (arr[compStack.peek()] > arr[i]) {
                res[i] = compStack.peek();
                compStack.push(i);
                continue;
            }
        }

        return res;
    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }

    public static void main(String[] args){
        int[] uniqueArr = { 3, 4, 5, 1, 2 };
        Node head = getMaxTree(uniqueArr);
        System.out.println(head);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);
    }
}
