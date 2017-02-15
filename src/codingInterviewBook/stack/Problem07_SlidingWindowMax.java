package codingInterviewBook.stack;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackPopLevel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jc on 2/15/2017.
 */


public class Problem07_SlidingWindowMax {


    /**
     * 复杂度过高 为O(n*w)
     * @param arr
     * @param w
     * @return
     */
    public static int[] getMaxWindow(int[] arr,int w){
        int[] res=new int[arr.length-w+1];
        for (int i = 0; i < arr.length - w + 1; i++) {
            int[] temp=new int[w];
            for (int j = 0; j < w; j++) {
                temp[j]=arr[j+i];
            }
            res[i]=findMax(temp);
        }
        return res;
    }

    public static int findMax(int[] array){
        int max=Integer.MIN_VALUE;
        for(int i : array){
            if(i>max){
                max=i;
            }
        }
        return max;
    }


    /**
     * 复杂度O(N)
     * @param arr
     * @param w
     * @return
     */
    public static int[] getMaxWindow2(int[] arr,int w){
        int[] res=new int[arr.length-w+1];
        int index=0;
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty()&&arr[deque.getLast()]<=arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            System.out.println(deque);

            if(!deque.isEmpty()&&deque.getFirst()==i-w){
               deque.removeFirst();
            }

            if (i >= w - 1) {
                res[index++] = arr[deque.peekFirst()];
            }
        }
        return res;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow2(arr, w));
    }
}
