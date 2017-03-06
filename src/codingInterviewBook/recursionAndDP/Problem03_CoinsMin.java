package codingInterviewBook.recursionAndDP;

/**
 * Created by jc on 3/3/2017.
 */


public class Problem03_CoinsMin {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int coinsCat = coins.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[coinsCat][amount + 1];

        //构建二维数组的第0行
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = max;
            if (i - coins[0] >= 0 && dp[0][i - coins[0]] != max) {
                dp[0][i] = dp[0][i - coins[0]] + 1;
            }
        }


        for (int i = 1; i < coinsCat; i++) {
            for (int j = 0; j <= amount; j++) {
                int left=max;
                if(j-coins[i]>=0&&dp[i][j-coins[i]]!=max){
                    left=dp[i][j-coins[i]]+1;
                }
                dp[i][j]=Math.min(left,dp[i-1][j]);
            }
        }
//        print2DArray(dp);
        return dp[coinsCat-1][amount]!=max?dp[coinsCat-1][amount]:-1;

    }

    public void print2DArray(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] coins=new int[]{3,5};
        int amount=2;
        System.out.println(new Problem03_CoinsMin().coinChange(coins,amount));
    }
}
