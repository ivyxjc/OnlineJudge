package xyz.ivyxjc.pat;

import java.util.Scanner;

/*
Input

Each input file contains one test case. Each case contains a pair of integers a and b where -1000000 <= a, b <= 1000000.
The numbers are separated by a space.



Output

For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.
Sample Input-1000000 9

Sample Output-999,991


 */

/**
 * Created by xgh on 2016/1/30.
 */
public class _1001_A_plus_B_Format_20 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int sum=a+b;
        String s="";
        if((sum/1000)==0){
            System.out.println(sum);
            return;
        }
        while(sum/1000!=0){

            int tmp=Math.abs(sum%1000);
            if(tmp<10){
                s="00"+tmp+s;
            }
            else if(tmp<100){
                s="0"+tmp+s;
            }
            else{
                s=tmp+s;
            }
            s=","+s;
            sum=sum/1000;
        }
        s=sum+s;
        System.out.println(s);
    }

}
