package codeForces_div2;

import java.util.Scanner;

/**
 * Created by xgh on 2016/2/7.
 */
public class CF342_C {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        String[] res=new String[n];
        int ssss=0;
        for(int i=0;i<n;i++){
            res[i]="";
        }
        if(k==1){
            for(int i=0;i<n;i++){
                int j=0;
                while(j<n){
                    res[i]+=(i*n+j+1)+" ";
                    if(j==0)
                        ssss+=i*n+j+1;
                    j++;

                }
            }
        }else{
            int tmpk=0;
            int tmptmp=1;
            while(tmpk<k-1){
                for(int i=0;i<n;i++){
                    res[i]+=(tmptmp)+" ";
                    tmptmp++;
                }
                tmpk++;
            }
            int flag=n*(k-1)+1;
            for(int i=0;i<n;i++){
                int j=k-1;
                while(j<n){
                    res[i]+=(flag)+" ";
                    if(j==k-1){
                        ssss+=flag;
                    }
                    j++;
                    flag++;
                }
            }
        }

        System.out.println(ssss);
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}
