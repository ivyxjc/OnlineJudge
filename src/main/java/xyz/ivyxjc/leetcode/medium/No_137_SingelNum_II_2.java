package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 4/21/2016.
 */
public class No_137_SingelNum_II_2 {
    public int singleNumber(int[] nums) {
        int [] count=new int[Integer.BYTES*8];
        int res=0;
        for(int i=0;i<count.length;i++){
            int tmp=1<<i;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&tmp)!=0){
                    count[i]++;
                }
            }
            if(count[i]%3!=0){
                res=res|tmp;
            }
        }

        return res;
    }


    public static void main(String[] args){

        int [] nums={-2,-2,1,1,-3,1,-3,-3,-4,-2};
        No_137_Single_Num_II test=new No_137_Single_Num_II();
        System.out.println(test.singleNumber(nums));
        System.out.println();
    }
}
