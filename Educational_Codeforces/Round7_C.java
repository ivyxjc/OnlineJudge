package Educational_Codeforces;

import java.util.Scanner;

/**
 * Created by xgh on 2016/2/16.
 */


//蛮力算法，直接依次比较 ，不等即break
public class Round7_C {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int arrayLength=in.nextInt();
        int queryTimes=in.nextInt();
        long[] array=new long[arrayLength];
        in.nextLine();
        String second_line=in.nextLine();
        String[] second_line_array=second_line.split(" ");
//        System.out.println(second_line_array.length);
//        for(int i=0;i<second_line_array.length;i++){
//            System.out.println(second_line_array[i]);
//        }
        for(int i=0;i<arrayLength;i++){
            array[i]=Long.parseLong(second_line_array[i]);
        }
        long[] res=new long[queryTimes];
        for(int i=0;i<queryTimes;i++){

            int left=in.nextInt()-1;
            int right=in.nextInt()-1;
            long x=in.nextLong();
            for(int j=left;j<=right;j++){
                if(array[j]!=x){
                    res[i]=j+1;
                    break;
                }
                if(j==right&& array[j]==x){
                   res[i]=-1;
                }
            }
        }
        for(int i=0;i<queryTimes;i++){
            System.out.println(res[i]);
        }
    }
}
