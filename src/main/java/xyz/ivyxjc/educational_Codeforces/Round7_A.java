package xyz.ivyxjc.educational_Codeforces;

import java.util.Scanner;

/**
 * Created by xgh on 2016/2/16.
 */
public class Round7_A{
        public static void main(String[] args){
            Scanner in=new Scanner(System.in);
            long  a=in.nextLong();
            //long a=1000000000000L;
            long a_one=count(a);

            //System.out.println(a_one);

            if(a_one*a_one+a_one==2*a){
                System.out.println(a_one);
            }else{
                long tmp=(long)a-(a_one*a_one+a_one)/2;
                System.out.println(tmp);
            }
            return;
        }

        public static long count(long  num) {
            long num_two = 2 * num;
            long i = (long) Math.sqrt(num_two) - 1;
            //System.out.println(i);
            if (i <= 0) {
                i = 0;
            }
            for (; i <= num; i++) {
                //System.out.println(i);
                if (i * i + i == num_two) {
                    return i;
                }
                if (i * i + i > num_two) {
                    return i - 1;
                }
            }
            return 0;
        }
}
