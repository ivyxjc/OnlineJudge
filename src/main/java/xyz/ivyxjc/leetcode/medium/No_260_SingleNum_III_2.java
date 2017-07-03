package xyz.ivyxjc.leetcode.medium;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jc on 4/21/2016.
 */

/**
 * similar problems:136,137,260
 */

/**
 * 此方法比较暴力，将数字出现的个数放存在map中。效率也比较低
 *
 * 使用TreeMap： beat 3%
 * 使用HashMap: beat 8%
 */
public class No_260_SingleNum_III_2 {
    public int[] singleNumber(int[] nums) {
        int [] res=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
//                int existNum= map.get(nums[i]);
//                existNum+=1;
                map.put(nums[i],2);
            }else {
                map.put(nums[i],1);
            }
        }
        int index=0;
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Integer pos=(Integer)it.next();
            Integer val=map.get(pos);
            if(val.compareTo(2)!=0){
                res[index]=pos;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int [] nums={1, 2, 1, 3, 2, 5};
        No_260_SingleNum_III_2 test=new No_260_SingleNum_III_2();
        int [] res=test.singleNumber(nums);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
