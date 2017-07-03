package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 4/23/2016.
 */

/**
 * difficulty: 1
 */

/**
 *question:  Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 */

/**
 * 该题比较简单，主要是输入的数组有0时的一些情况。
 *
 */

public class No_238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        long product =1;
        int zeroNum=0;
        int zeroPosi=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroNum+=1;
                zeroPosi=i;
            }
            if(nums[i]==0 && zeroNum==1){
                continue;
            }
            product*=nums[i];


        }

        int[] res=new int[nums.length];
        if(zeroNum==2){
            return res;
        }

        if(zeroNum==1){
            res[zeroPosi]=(int)product;
        }

        if(zeroNum==0){
            for(int i=0;i<nums.length;i++){
                res[i]=(int)product/nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int [] src={ 1,2,3,4,0,0};
        No_238_ProductofArrayExceptSelf test=new No_238_ProductofArrayExceptSelf();
        int [] res=test.productExceptSelf(src);
        for(int i:res){
            System.out.println(i);
        }
    }
}
