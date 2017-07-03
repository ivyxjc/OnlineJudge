package xyz.ivyxjc.util;

/**
 * Created by jc on 3/4/2017.
 */


public class PrintCollections<T> {
    public void printArray(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    public void print2DArray(T[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
