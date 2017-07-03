package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 4/21/2016.
 */

/**
 * difficulty: 4
 */

/**
 * similar problems:136,137,260
 */

/**
 * 在论坛中找到一种好方法，不需要排序，也不需要额外空间存储。
 *
 * 因为除了目标之外的两个数字都会出现两次
 *
 * 用时最短的方法
 */
public class No_260_SingleNum_III_3 {

    public int[] singleNumber(int[] nums) {

        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;


        int[] rets = {0, 0};
        for (int num : nums)
        {
            if ((num & diff) == 0)
            {
                rets[0] ^= num;
            }
            else
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args){
        int [] data={124,156,124,156,356,567,356,789,567,988};
        No_260_SingleNum_III_3 test=new No_260_SingleNum_III_3();
        int [] res=test.singleNumber(data);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
