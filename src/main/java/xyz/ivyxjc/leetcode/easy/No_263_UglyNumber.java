package xyz.ivyxjc.leetcode.easy;

/**
 * Created by 2438981 on 2016/11/17.
 */
public class No_263_UglyNumber {
    public boolean isUgly(int num) {
        if(num<=0){
            return false;
        }
        if(num==1){
            return true;
        }
        if(num==2||num==3||num==5){
            return true;
        }
        if(num%2==0){
            return isUgly(num/2);
        }
        if(num%3==0){
            return isUgly(num/3);
        }
        if(num%5==0){
            return isUgly(num/5);
        }
        return false;
    }

    public static void main(String[] args){
        No_263_UglyNumber test=new No_263_UglyNumber();
        System.out.println(test.isUgly(14));
    }
}
