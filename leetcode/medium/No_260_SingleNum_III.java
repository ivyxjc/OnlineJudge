package leetcode.medium;

/**
 * Created by jc on 4/21/2016.
 */


/**
 * similar problems:136,137,260
 */


/**
 * Given an array of numbers nums, in which exactly two elements appear only once and
 * all the other elements appear exactly twice. Find the two elements that appear only once.
 *  For example:
 *
 *  Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */


/**
 * 此方法和136题的方法基本一致，根据题意稍做修改。
 *
 *
 * 结果：Accepted。  beat 32.26%
 */
public class No_260_SingleNum_III {
    public int[] singleNumber(int[] nums) {
        sort(nums);
        int index=0;
        int[] res=new int[2];
        for(int i=0;i<nums.length-1;){
            if(nums[i]==nums[i+1]){
                i+=2;
            }else{
                res[index]=nums[i];
                i+=1;
                index+=1;
            }
        }
        if(index==1){
            res[index]=nums[nums.length-1];
        }
        return res;
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
        int [] nums={1, 2, 1, 3, 2, 5};
        No_260_SingleNum_III test=new No_260_SingleNum_III();
        int [] res=test.singleNumber(nums);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
