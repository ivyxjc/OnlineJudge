package xyz.ivyxjc.codeForces_div2;

import java.util.Scanner;

/**
 * Created by xgh on 2016/2/7.
 */
public class CF342_B {
    public static String big;
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        big=in.nextLine();
        String sub=in.nextLine();
        int sub_length=sub.length();
        int max=0;
        int res=0;

        System.out.println(res);
    }
//    public static boolean change(String sub){
//        int res=0;
//        int sub_length=sub.length();
//        for(int i=0;i<big.length()-sub_length+1;i++){
//
//
//
//
//            }
//            String tmp=s.toString();
//            if(compare(tmp,sub)){
//                big=rep(big,big.length()-sub_length);
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean compare(String a,String b){
        if(a.length()!=b.length())
            return false;
        int count=0;
        int length=a.length();
        int i=0;
        while(i<length){
            if(a.charAt(i)!=b.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static String rep(String a,int index){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a.length();i++){
            if(i!=index){
                sb.append(a.charAt(i));
            }
            else {
                sb.append("#");
            }
        }
        return sb.toString();
    }

}
