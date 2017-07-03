//package CodeForces_div2;
//
//import java.io.*;
//import java.xyz.ivyxjc.util.*;
//
///**
// * Created by jc on 3/7/2016.
// */
//public class CF345_B {
//
//    private static Reader reader = null;
//    private static Writer writer = null;
//    public static void main(String[] args) {
//        reader = new InputStreamReader(System.in);
//        writer = new OutputStreamWriter(System.out);
//        int N=getInt();
//        xyz.ivyxjc.algorithm.list<Integer> beautyArray=new ArrayList<>();
//        for(int i=0;i<N;i++){
//            beautyArray.add(getInt());
////            Random a=new Random();
////            if(i<500)
////                beautyArray.add(1);
////            else{
////                beautyArray.add(0);
////            }
//        }
////        for(int i=0;i<N;i++){
////            System.out.println(beautyArray.get(i));
////        }
//        Collections.sort(beautyArray);
//        xyz.ivyxjc.algorithm.list<Integer> numOfDuplicate=new ArrayList<>();
//
//        Integer a=200;
//        Integer b=200;
//        int numOfDu=1;
//        for(int i=1;i<beautyArray.size();i++){
//            if(beautyArray.get(i).compareTo(beautyArray.get(i-1))==0){
//                numOfDu++;
//            }else{
//                numOfDuplicate.add(numOfDu);
//                numOfDu=1;
//            }
//            if(i==beautyArray.size()-1){
//                numOfDuplicate.add(numOfDu);
//            }
//        }
////        for(int i=0;i<beautyArray.size();i++){
////            System.out.println(beautyArray.get(i));
////        }
//        for(int i=0;i<numOfDuplicate.size();i++){
//            //System.out.println(numOfDuplicate.get(i));
//        }
//        int res=0;
//        while(true){
//            int tt=count(numOfDuplicate);
//            if(tt==0||tt==1){
//                break;
//            }
//            res+=tt-1;
//            for(int i=0;i<tt;i++){
//                int tmp=numOfDuplicate.get(i)-1;
//                numOfDuplicate.set(i,tmp);
//            }
//
//        }
//        System.out.println(res);
//    }
//
//    public static int count(xyz.ivyxjc.algorithm.list<Integer> xyz.ivyxjc.algorithm.list){
//        int res=0;
//        int size=xyz.ivyxjc.algorithm.list.size();
//        for(int i=0;i<size;i++){
//            if(xyz.ivyxjc.algorithm.list.get(i)>=1){
//                res++;
//            }
//        }
//        return res;
//    }
//
//    public static int getInt() {
//        int read;
//        int res = 0;
//        boolean isNegative = false;// 是不是负数
//        try {
//            while ((read = reader.read()) != -1) {
//                if ((char) read == '-') {
//                    res = 0;
//                    isNegative = true;
//                    break;
//                } else if (isNumber((char) read)) {
//                    res = read - '0';
//                    break;
//                }
//            }
//            while ((read = reader.read()) != -1) {
//                char ch = (char) read;
//                if (isNumber(ch)) {
//                    res = res * 10 + (read - '0');
//                } else {
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        if (isNegative == true) {
//            res = -1 * res;
//        }
//        return res;
//    }
//
//    public static boolean isBlank(char ch) {
//        if (ch == '\r' || ch == '\n' || ch == ' ') {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isNumber(char ch) {
//        if (ch <= '9' && ch >= '0') {
//            return true;
//        }
//        return false;
//    }
//}
//
//
////1 1 5 1 2 5 7 8 5 8