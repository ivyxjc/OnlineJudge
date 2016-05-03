package leetcode.medium;

import java.math.*;
/**
 * Created by jc on 4/18/2016.
 */

/**
 * 给定一个数字num，计算从0-num所有数字的二进制数中1的数量
 * 0先直接返回
 * solution 1:将数字分为1,2-3,4-7,8-15,16-31....
 * 其中后一组前一半和前一组是一样的，只需计算后一组的后一半即可。
 * 时间复杂度O(N * sizeof(integer)/2)
 *
 * solution 2(更优):将数字分为1,2-3,4-7,8-15,16-31....
 * 其中后一组前一半和前一组是一样的，后一组是在前一组的每一个数字上+1
 * 该方法复杂度为O(N+ sizeof(integer)* lg N)
 */
public class No_338_Counting_Bits {
    /**
     * 该方法复杂度为O(N * sizeof(integer))
     * @param num
     * @return
     */
//    public static int[] countBits(int num) {
//        int[] res=new int[num+1];
//        if(num==0){
//            return new int[1];
//        }
//        int index=2;
//        res[0]=0;
//        res[1]=1;
//        while(index<=num){
//            if(getOneNums(index)==1) {
//                int count = 0;
//                int biggestCount=num-index;
//
//                while (count < index/2 && count<=biggestCount) {
//                    res[index + count] = res[index / 2 + count];
//                    count += 1;
//                }
//
//                while (count < index && count<=biggestCount) {
//                    res[index + count] = getOneNums(index+count);
//                    count+=1;
//                }
//            }
//            index+=1;
//        }
//
//        return res;
//    }


    /**
     * 该方法复杂度为O(N+ sizeof(integer)* lg N)
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] res=new int[num+1];
        if(num==0){
            return new int[1];
        }
        int index=2;
        res[0]=0;
        res[1]=1;
        while(index<=num){
            if(getOneNums(index)==1) {
                int count = 0;
                int biggestCount=num-index;

                while (count < index/2 && count<=biggestCount) {
                    res[index + count] = res[index / 2 + count];
                    count += 1;
                }
                int secondCount=0;
                while (count < index && count<=biggestCount) {
                    res[index + count] = res[index+secondCount]+1;
                    count+=1;
                    secondCount+=1;
                }
            }
            index+=1;
        }

        return res;
    }

    public static int getOneNums(int num){
        int count=0;
        int tmp_num=num;
        while(tmp_num>0){
            count+=tmp_num%2;
            tmp_num=tmp_num/2;
        }

        return count;
    }


    public static void main(String[] args){
//        System.out.println(getOneNums(15));
        int[] res=countBits(31);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
