package leetcode.medium;

import java.util.*;

/**
 * Created by jc on 6/22/2016.
 */

/**
 * 就是先排序，再两重循环再二分查找，最后结果排重
 * 这个解法时间复杂度O(N^2*lgN),  但是java和python版本都Time limited exceed/
 */
public class No15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
//        for (int i = 0; i <numsList.size() ; i++) {
//            System.out.println(numsList.get(i));
//        }

        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<=2){
            return res;
        }
        int zero_rank=binarySearch(numsList,0,numsList.size()-1,0);
        if(zero_rank>=nums.length){
            return res;
        }
        int zero_rank_copy=zero_rank;
        int min_zero_rank=0;
        int max_zero_rank=0;
        int zero_flag=0;

        if(numsList.get(zero_rank)==0){
            while(zero_rank_copy>0){
                zero_rank_copy--;
                if(numsList.get(zero_rank_copy)!=0){
                    min_zero_rank=zero_rank_copy+1;
                    break;
                }
                min_zero_rank=zero_rank_copy;
            }
            zero_rank_copy=zero_rank;
            while(zero_rank_copy<nums.length-1){
                zero_rank_copy++;
                if(numsList.get(zero_rank_copy)!=0){
                    max_zero_rank=zero_rank_copy-1;
                    break;
                }
                max_zero_rank=zero_rank_copy;
            }
        }
        System.out.println(max_zero_rank);
        System.out.println(min_zero_rank);
        if((max_zero_rank-min_zero_rank)>=2){
            zero_flag=1;
        }
        List<Integer> zeroList=new ArrayList<>();
        zeroList.add(0);
        zeroList.add(0);
        zeroList.add(0);

        if(zero_flag==1){
            res.add(zeroList);
        }
        for(int i=0;i<zero_rank-1;i++){
            for(int j=i+1;j<zero_rank;j++){
                int negative_sum=numsList.get(i)+numsList.get(j);
                int searchResRank=binarySearch(numsList,zero_rank,numsList.size()-1,-negative_sum);
                if(searchResRank==numsList.size()){
                    continue;
                }
                if(numsList.get(searchResRank)==-negative_sum){
                    List<Integer> a=new ArrayList<>();
                    a.add(numsList.get(i));
                    a.add(numsList.get(j));
                    a.add(numsList.get(searchResRank));
                    res.add(a);
                }
            }
        }

        for(int i=zero_rank;i<numsList.size()-1;i++){
            for(int j=i+1;j<numsList.size();j++){
                int positive_sum=numsList.get(i)+numsList.get(j);
                int searchResRank=binarySearch(numsList,0,zero_rank-1,-positive_sum);
                if(searchResRank==numsList.size()){
                    continue;
                }
                if(numsList.get(searchResRank)==-positive_sum){
                    List<Integer> a=new ArrayList<>();
                    a.add(numsList.get(i));
                    a.add(numsList.get(j));
                    a.add(numsList.get(searchResRank));
                    res.add(a);
                }
            }
        }

        HashSet<List<Integer>> hashset=new HashSet<>();




        for(int i=0;i<res.size();i++){
            Collections.sort(res.get(i));
            hashset.add(res.get(i));
        }

        if(zero_flag==0){
            hashset.remove(zeroList);
        }

        Iterator it=hashset.iterator();
        res.clear();
        while(it.hasNext()){
            res.add((ArrayList<Integer>)(it.next()));
        }

        return res;


    }

    public int binarySearch(List<Integer> nums,int lo,int hi,int target){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(target<nums.get(mid)){
                hi=mid-1;
            }else if (target>nums.get(mid)){
                lo=mid+1;
            }else{
                return mid;
            }
        }
        return lo;
    }


    public static void main(String[] args){
        No15_3Sum test=new No15_3Sum();
        int[] nums={0,0,0};
        List<List<Integer>> res=test.threeSum(nums);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }


}
