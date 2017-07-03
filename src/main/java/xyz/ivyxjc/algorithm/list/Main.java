package xyz.ivyxjc.algorithm.list;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public class Main {
    public static void main(String[] args){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        try{
            System.out.println(list.get(2));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        System.out.println(100);

        int[] aa=new int[3];
//        System.out.println(aa[3]);
    }
}
