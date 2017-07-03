package xyz.ivyxjc.leetcode.medium;

/**
 * Created by jc on 4/23/2016.
 */

/**
 * difficulty:5
 *
 * 难度主要在于想到解法：即找到所有递增区间
 */

/**
 * 已知物品每天的价格，讨论通过买卖可以赚到的最多利润。卖之前必须买，再一次买之前必须卖掉。
 */
public class No_122_BestTimetoBuyandSellStock_II {

    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length;){
            int plus=1;
            int flag=0;

            while (i+plus<prices.length&&prices[i+plus-1]<prices[i+plus]){
                plus+=1;
                flag=1;
            }
            if(flag==1){
                maxProfit+=prices[i+plus-1]-prices[i];
            }
            i+=plus;
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int [] prices={1,2,4,5,6,4,7};
        No_122_BestTimetoBuyandSellStock_II test=new No_122_BestTimetoBuyandSellStock_II();
        System.out.println(test.maxProfit(prices));
    }
}
