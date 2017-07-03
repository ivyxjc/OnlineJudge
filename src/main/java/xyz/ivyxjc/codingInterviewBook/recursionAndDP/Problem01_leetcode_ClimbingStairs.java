package xyz.ivyxjc.codingInterviewBook.recursionAndDP;

/**
 * Created by jc on 3/1/2017.
 */


public class Problem01_leetcode_ClimbingStairs {

    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2||n==3){
            return n;
        }
        return matrixPower(new int[][]{{1,1},{1,0}},n-2)[0][0];
    }

    public static int fibIteration(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2||n==3){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    //矩阵乘法
    public static int[][] multiMatrix(int[][] m1,int [][] m2)throws IllegalArgumentException{
        if(m1[0].length!=m2.length){
            throw new IllegalArgumentException("矩阵输入错误, 无法进行乘法.");
        }
        int[][] res=new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
//        printMatrix(res );
        return res;
    }

    public int[][] matrixPower(int[][] matrix,int p) throws IllegalArgumentException{
        if (matrix[0].length!=matrix.length){
            throw new IllegalArgumentException("矩阵输入错误, 无法进行乘法.");
        }
        int[][] res=new int[matrix.length][matrix.length];
        for (int i = 0; i < res.length; i++) {
            res[i][i]=1;
        }
        int [][] tmp=matrix;

        while (p>0){
            int flag=p&1;
            if(flag==1){
                res=multiMatrix(res,tmp);
            }
            tmp=multiMatrix(tmp,tmp);
            p=p>>1;
        }
        return multiMatrix(new int[][]{{2,1}},res);
    }


    public static void main(String[] args){
        System.out.println(new Problem01_leetcode_ClimbingStairs().climbStairs(4));
        System.out.print(fibIteration(6));
    }
}
