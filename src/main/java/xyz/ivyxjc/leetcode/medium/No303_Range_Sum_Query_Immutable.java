package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 12/3/2016.
 */
public class No303_Range_Sum_Query_Immutable {
    private int [] nums;
    private int [] p;

    public No303_Range_Sum_Query_Immutable(int[] nums) {
        this.nums=nums;
        p=new int[nums.length];
        p[1]=nums[0];
        for(int i=1;i<p.length;i++){
            p[i]=p[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(nums.length==0){
            return 0;
        }
        return p[j]-p[i]+nums[i];
    }

    public static void main(String[] args){
        No303_Range_Sum_Query_Immutable numArray = new No303_Range_Sum_Query_Immutable(new int[]{});
        System.out.println(numArray.sumRange(0, 0));
        System.out.println(numArray.sumRange(5,5));
        System.out.println(numArray.sumRange(0,5));
    }
}
