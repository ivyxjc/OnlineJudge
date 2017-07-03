package xyz.ivyxjc.codingInterviewBook.recursionAndDP;

/**
 * Created by jc on 3/3/2017.
 */


public class Problem04_CoinsWay {
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {

        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;

        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        }else{
            int mapValue=0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue=map[index+1][aim-arr[index]*i];
                if(mapValue!=0){
                    res+=mapValue==-1?0:mapValue;
                }else{
                    res+=process2(arr,index+1,aim,map);
                }
            }
        }
        map[index][aim]=res==0?-1:res;
        return res;
    }


    public static void main(String[] args) {
        int t = coins1(new int[]{5, 10, 25, 1}, 15);
        System.out.println(t);
    }
}
