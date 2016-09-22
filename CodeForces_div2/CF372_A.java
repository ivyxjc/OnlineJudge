package CodeForces_div2;

import java.util.Scanner;

/**
 * Created by jc on 9/22/2016.
 */
public class CF372_A {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        int wordNum=scanner.nextInt();
        int delayTime=scanner.nextInt();
        int[] typeTime=new int[wordNum];
        for(int i=0;i<wordNum;i++){
            typeTime[i]=scanner.nextInt();
        }

        int res=0;
        for(int i=0;i<wordNum-1;i++){
            if(delayTime>=(typeTime[i+1]-typeTime[i])){
                res+=1;
            }else{
                res=0;
            }
        }
        res+=1;
        System.out.print(res);
    }
}
