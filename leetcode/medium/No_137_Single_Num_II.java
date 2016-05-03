package leetcode.medium;

/**
 * Created by jc on 4/21/2016.
 */


/**
 * similar problems:136,137,260
 */

/**
 * question:
 *  Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */
public class No_137_Single_Num_II {

    public int singleNumber(int[] nums) {
        sort(nums);
        int res=0;
        for(int i=0;i<nums.length-1;){
            if(nums[i]==nums[i+2]){
                i+=3;
            }else{
                res=nums[i];
                i+=3;
                return res;
            }
        }
        return nums[nums.length-1];
    }

    private void sort(int[] a){
        sort(a,0,a.length-1);
    }

    private int partition(int [] a,int lo,int hi){
        int i=lo;
        int j=hi+1;

        int v=a[lo];
        while(true){
            while(a[++i]<v){
                if(i==hi){
                    break;
                }
            }
            while (v<a[--j]){
                if(j==lo){
                    break;
                }
            }
            if(i>=j)
                break;

            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private void sort(int[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    public static void main(String[] args){

        int [] nums={1,2,3,1,1,4,4,4,2,2};
        No_137_Single_Num_II test=new No_137_Single_Num_II();
        System.out.println(test.singleNumber(nums));
    }

}
