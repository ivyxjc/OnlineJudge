package xyz.ivyxjc.leetcode.easy;

/**
 * Created by jc on 5/3/2016.
 */

/**
 * 用先快排 再找 超时了
 */
public class No_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
//            int length=nums.length;
//            Set<Integer> set=new HashSet<>();
//            for(int i=0;i<length;i++){
//                if(set.contains(nums[i])){
//                    return true;
//                }
//                set.add(nums[i]);
//            }
//            return false;

        int length=nums.length;
        if(length==0){
            return false;
        }
        sort(nums);
        for(int i=0;i<length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public void sort(int[] a){
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
        int [] data={1,2,3};
        No_217_ContainsDuplicate test=new No_217_ContainsDuplicate();
        System.out.println(test.containsDuplicate(data));
    }
}
