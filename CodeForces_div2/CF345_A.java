package CodeForces_div2;

import java.util.Scanner;

/**
 * Created by jc on 3/7/2016.
 */
public class CF345_A {

    private static int a1=0;
    private static int a2=0;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a1=in.nextInt();
        int a2=in.nextInt();
        int minute=0;
//        while(a1!=0&&a2!=0) {
//            if (a1 == 1) {
//                if(a2==1){
//                    System.out.println(0);
//                    return;
//                }else{
//                    a1++;
//                    minute++;
//                    a2-=2;
//                }
//            }else{
//                if(a2==1){
//                    a2++;
//                    minute++;
//                    a1-=2;
//                }else{
//                    a2++;
//                    minute++;
//                    a1-=2;
//                }
//            }
//        }
        while(a1!=0&&a2!=0){
            if(a1==1&&a2==1){
                System.out.println(minute);
                return;
            }
            int[] tmp=count(a1,a2);
            a1=tmp[0];
            a2=tmp[1];
            minute+=tmp[2];
        }
        System.out.println(minute);

    }

    public static int[] count(int a,int b){
        int small=(a<b?a:b);
        int big;
        if(small==a){
            big=b;
        }else{
            big=a;
        }
        if(big==2){
            int[] tmpres={1,0,1};
            return tmpres;
        }
        int tmp=0;
        if(big%2==0){
            small+=big/2-1;
            tmp=big/2-1;
            big=2;
        }else{
            small+=big/2;
            tmp=big/2;
            big=big%2;
        }

        int[] res={small,big,tmp};
        return res;
    }
}

