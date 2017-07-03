package xyz.ivyxjc.beautyofPrograme;

/**
 * Created by jc on 8/21/2016.
 */
public class _2_2_Factorial {

    public static int lowestOne(int N){
        int ret=0;
        while (N!=0){
            N>>=1;
            ret+=N;

        }
        return ret;
    }

    public static int lowestOne_2(int N){
        int copyN=N;
        int res=0;

        int comp=1;
        while(copyN!=0){
            int M=copyN;
            while(M!=0){
                int a=M&comp;
                System.out.println("a :"+a);
                res+=a;
                M--;
            }
            System.out.println("res :"+res);
            System.out.println("copy:"+copyN);
            copyN>>=1;
            comp<<=1;
            System.out.println("comp:"+comp);
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(_2_2_Factorial.lowestOne(6));
        System.out.println(_2_2_Factorial.lowestOne_2(6));
    }

}
