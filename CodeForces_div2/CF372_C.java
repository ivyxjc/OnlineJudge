package CodeForces_div2;

import java.util.Scanner;

/**
 * Created by ivyxjc on 2016/9/23.
 */
public class CF372_C  {

    public static long cal(long k){
        long res=0l;
        if(k==1){
            return 2l;
        }
        res=k*(k+1)*(k+1)-(k-1);
        return res;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<n+1;i++){
            System.out.println(cal((long)i));
        }
    }
}
