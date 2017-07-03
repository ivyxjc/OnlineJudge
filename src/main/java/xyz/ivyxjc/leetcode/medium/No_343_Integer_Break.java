package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 4/23/2016.
 */

/**
 * difficulty:6
 * 主要难点在于发现将该数尽量拆分为3的点，原因见ivyxjc.xyz.
 *
 * 另外也可以使用动态规划的方法
 *
 */

/**
 * 整数拆分求积问题。给一个自然数n，把它拆分为若干个数的和，记这若干个数的乘积为M，求M的最大值。
 */
public class No_343_Integer_Break {
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }
        int mod=n%3;
        int res=0;
        res=(int)Math.pow(3,n/3);
        System.out.println(res);
        if(mod==1){
            res=res/3*4;
            return res;
        }

        if(mod==2){
            res=res*2;
            return res;
        }
        return res;
    }

    public static void main(String[] args){
        No_343_Integer_Break test=new No_343_Integer_Break();
        System.out.println(test.integerBreak(5));
    }
}
