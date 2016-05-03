package PAT;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by xgh on 2016/1/30.
 */
public class _1002_A_plus_B_for_Polynomials_25_ {
    public static void main(String[] args){
        int aa=1024;
        double [] exponents=new double[aa];
        for(int i=0;i<aa;i++){
            exponents[i]=0.0;
        }
        Scanner in=new Scanner(System.in);
        int a_num=in.nextInt();
        while(a_num!=0){
            int tmp=in.nextInt();
            exponents[tmp]+=in.nextDouble();
            a_num--;
        }
        in.nextLine();
        int b_num=in.nextInt();
        while(b_num!=0){
            int tmp=in.nextInt();
            exponents[tmp]+=in.nextDouble();
            b_num--;
        }
        String s="";
        int count=0;
        for(int i=0;i<aa;i++){
            if(exponents[i]!=0){
                if(((int)(exponents[i]*10))%10!=0)
                    s=" "+i+" "+exponents[i]+s;
                else{
                    s=" "+i+" "+(int)exponents[i]+s;
                }
                count++;
            }
        }
        s=count+s;
        System.out.println(s);

    }
}
