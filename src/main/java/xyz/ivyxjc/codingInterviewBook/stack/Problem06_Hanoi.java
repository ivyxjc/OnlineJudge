package xyz.ivyxjc.codingInterviewBook.stack;

/**
 * Created by jc on 2/15/2017.
 */


public class Problem06_Hanoi {

    private static int step=0;

    public static void move(int n, String a, String b){
        if(!a.equals("mid")&&!b.equals("mid")){
            System.out.println("move No."+n+" from "+a+" to mid");
            System.out.println("move No."+n+" from mid to "+b);
            step+=2;
        }else {
            System.out.println("move No."+n+" from "+a+" to "+b);
            step++;
        }
    }

    public static void process(int n,String left, String mid, String right){
        if(n==1){
            move(1,left,right);
            return;
        }
        process(n-1,left,mid,right);
        move(n,left,mid);
        process(n-1,right,mid,left);
        move(n,mid,right);
        process(n-1,left,mid,right);
    }


    public static void main(String[] args){
        process(4,"left","mid","right");
        System.out.println(step);
    }
}
