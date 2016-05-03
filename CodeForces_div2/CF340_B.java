package CodeForces_div2;

import java.util.Scanner;

/**
 * Created by xgh on 2016/1/31.
 */
public class CF340_B {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int cakePieces=in.nextInt();
        in.nextLine();

        int [] chocolateStatus=new int[cakePieces];
        boolean flag=false;
        int tmp=-1;
        int k=0;

        long res=1;

        while(cakePieces!=0) {
            cakePieces--;
            //System.out.println(cakePieces);
            int tmptmp=in.nextInt();
            if(tmptmp==1){
                flag=true;
                tmp++;
                k=0;
            }
            else if(tmptmp==0&&flag==true){
                chocolateStatus[tmp]++;
                k++;
            }
        }

        if(!flag){
            System.out.println(0);
            return;
        }

        for(int i=0;i<chocolateStatus.length;i++){
            if(chocolateStatus[i]!=0){
                res=res*(chocolateStatus[i]+1);
            }
        }
        if(k==0){
            System.out.println(res);
        }else
            System.out.println(res/(k+1));


    }


}
