package xyz.ivyxjc.codingInterviewBook.recursionAndDP;

/**
 * Created by jc on 3/4/2017.
 */


public class Problem03_MinimuPathSumOfMatrix {
    public int minPathSum(int[][] grid) {
        int[] dp=new int[grid[0].length];
        dp[0]=grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=grid[0][i]+dp[i-1];
        }

//        PrintIntArrays.printArray(dp);
        for (int i = 1; i < grid.length ; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(j==0){
                    dp[j]=dp[j]+grid[i][j];
                }else{
                    dp[j]=Math.min(dp[j-1]+grid[i][j],dp[j]+grid[i][j]);
                }
            }
//            PrintIntArrays.printArray(dp);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int[][] grid= new int[][]{
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0},
        };
        System.out.println(new Problem03_MinimuPathSumOfMatrix().minPathSum(grid));
    }
}
