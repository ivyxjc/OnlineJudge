package xyz.ivyxjc.codeForces_div2;



import java.util.Scanner;

/**
 * Created by xgh on 2016/1/31.
 */
public class CF340_C {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int flowersNum=in.nextInt();
        int [] flowerCoordinateX=new int[flowersNum];
        int [] flowerCoordinateY=new int[flowersNum];
        int x1=in.nextInt();
        int y1=in.nextInt();
        int x2=in.nextInt();
        int y2=in.nextInt();
        int index=0;
        while(flowersNum!=0){
            flowersNum--;
            flowerCoordinateX[index]=in.nextInt();
            flowerCoordinateY[index++]=in.nextInt();
        }
        int MaxToFirst=0;
        int MaxToSecond=0;
        for(int i=0;i<flowerCoordinateX.length;i++){
            int distanceSquareToFirst=getDistanceSquareBetweenTwoPoints(x1,y1,flowerCoordinateX[i],flowerCoordinateY[i]);
            int distanceSquareToSecond=getDistanceSquareBetweenTwoPoints(x2,y2,flowerCoordinateX[i],flowerCoordinateY[i]);
            if(distanceSquareToFirst<distanceSquareToSecond){
                MaxToFirst=(MaxToFirst<=distanceSquareToFirst?distanceSquareToFirst:MaxToFirst);
            }else{
                MaxToSecond=(MaxToSecond<distanceSquareToSecond?distanceSquareToSecond:MaxToSecond);
            }
        }
        int res=0;
        res=MaxToFirst+MaxToSecond;
        System.out.println(res);


    }

    public static int getDistanceSquareBetweenTwoPoints(int x1,int y1,int x2,int y2){
        int res=(y2-y1)*(y2-y1)+(x2-x1)*(x2-x1);
        return res;
    }
}
