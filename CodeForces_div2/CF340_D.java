package CodeForces_div2;

import java.util.Scanner;

/**
 * Created by xgh on 2016/1/31.
 */
public class CF340_D {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int [] x=new int[3];
        int [] y=new int[3];
        for(int i=0;i<3;i++){
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        int count1=0;
        int count2=0;
        for(int i=0;i<3;i++){
            for(int j=i+1;j<3;j++){
                if(x[i]==x[j]){
                    count1++;
                }
                if(y[i]==y[j]){
                    count2++;
                }
            }
        }
        if(count1==count2&&count1==0){
            System.out.println(3);
        }else{
            System.out.println(4-count1-count2);
        }
    }
}
