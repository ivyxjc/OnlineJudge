package xyz.ivyxjc.codingInterviewBook.recursionAndDP;

import java.math.BigInteger;

/**
 * Created by jc on 3/1/2017.
 */


public class Problem01_Fib {

    //递归的方法 时间复杂度 O(2^n) 空间复杂度O(2^n)
    public static int fibRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    //迭代的方法 时间复杂度O(n) 利用数组存储整个序列, 则额外空间复杂度O(n), 额外空间复杂度可以缩小到O(1), 只需要两个数字来保存前两个数即可.
    public static BigInteger fibIteration(int n) {
        if (n == 1) {
            return new BigInteger("1");
        }
        if (n == 0) {
            return new BigInteger("1");
        }


        BigInteger res = new BigInteger("0");
        BigInteger pre_1 = BigInteger.valueOf(1);
        BigInteger pre_2 = BigInteger.valueOf(0);

        for (int i = 2; i < n + 1; i++) {
            res = pre_1.add(pre_2);
            pre_2 = pre_1;
            pre_1 = res;
        }
        return res;
    }

    /**
     * 时间复杂度为O(lgN)的方法, 利用矩阵的方法, 与Fibonacci相关的题目都可以使用该方法:
     */
    public static BigInteger fibMatrix(int n) {
        if (BigInteger.ZERO.compareTo(BigInteger.valueOf(n)) == 0) {
            return new BigInteger("0");
        }
        if (BigInteger.ONE.compareTo(BigInteger.valueOf(n)) == 0) {
            return new BigInteger("1");
        }
        return matrixPower(new int[][]{{1, 1}, {1, 0}}, n)[0][0];
    }

    //计算矩阵matrix的p次方
    public static BigInteger[][] matrixPower(int[][] matrix, int p) throws IllegalArgumentException {
        if (matrix[0].length != matrix.length) {
            throw new IllegalArgumentException("矩阵输入错误, 无法进行乘法.");
        }
        BigInteger[][] res = new BigInteger[matrix.length][matrix.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = BigInteger.valueOf(0);
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i][i] = new BigInteger("1");
        }

        BigInteger[][] tmp = new BigInteger[matrix.length][matrix.length];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                tmp[i][j] = BigInteger.valueOf(matrix[i][j]);
            }
        }

        while (p > 0) {
            int flag = p & 1;
            if (flag == 1) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
//            printMatrix(tmp);
            p = p >> 1;
        }

        return multiMatrix(new BigInteger[][]{{new BigInteger("1"), new BigInteger("1")}}, res);
    }


    //矩阵乘法
    public static BigInteger[][] multiMatrix(BigInteger[][] m1, BigInteger[][] m2) throws IllegalArgumentException {
        if (m1[0].length != m2.length) {
            throw new IllegalArgumentException("矩阵输入错误, 无法进行乘法.");
        }
        BigInteger[][] res = new BigInteger[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                res[i][j] = new BigInteger("0");
            }
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] = res[i][j].add(m1[i][k].multiply(m2[k][j]));
                }
            }
        }
        return res;
    }


    public static void printMatrix(BigInteger[][] matrix) {
        System.out.println("-----------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("matrx[" + i + "]" + "[" + j + "]: " + matrix[i][j]);
            }
        }
        System.out.println("----------------------");
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();   //获取开始时间
        System.out.println(fibRecursion(15));
        long end = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (end - start) + "ms");

        start = System.nanoTime();   //获取开始时间
        System.out.println(fibIteration(100));
        end = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (end - start) + "ns");

        start = System.nanoTime();   //获取开始时间
        System.out.println(fibMatrix(10000000 - 2));
        end = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (end - start) + "ns");

//        System.out.println(BigInteger.ZERO.compareTo(BigInteger.valueOf(100)));
//        System.out.println(matrixPower(new int[][]{{1,1},{1,0}},6)[0][0]);
//        printMatrix(matrixPower(new int[][]{{1,1},{1,0}},6));
    }
}
