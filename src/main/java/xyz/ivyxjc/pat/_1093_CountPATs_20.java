package xyz.ivyxjc.pat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jc on 2/20/2017.
 */


public class _1093_CountPATs_20 {

    public static void main(String[] args){

        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        String str=null;
        str = in.next();





        int countt=0;
        int countp=0;
        int counta=0;


        int length=str.length();

//        char[] strArray=str.toCharArray();
        int res=0;

//        for (int i = 0; i < length; i++) {
//            if (str.charAt(i)=='T'){
//                countt++;
//            }
//        }
//
//
//        for (int i = 0; i < length; i++) {
//            char t=str.charAt(i);
//            if(str.charAt(i)=='T'){
//                countt--;
//            }
//            if(str.charAt(i)=='P'){
//                countp++;
//            }
//            if(str.charAt(i)=='A'){
//                res+=((countt%1000000007)*(countp%1000000007))%1000000007;
//            }
//        }
//        int countpa=0;
//        for (int i = 0; i < length; i++) {
//            char t=str.charAt(i);
//            if(t=='P'){
//                countp++;
//            }
//
//            if(t=='A'){
//                countpa+=countp*1;
//            }
//            if(t=='T'){
//                res+=countpa;
//            }
//        }
        System.out.println(res);

//        for (int i = 0; i < length; i++) {
//            if(strArray[i]=='T'){
//                countt++;
//            }
//        }
//
//
//
//        for (int i = 0; i < length; i++) {
//            if(strArray[i]=='T'){
//                countt--;
//            }
//            if(strArray[i]=='P'){
//                countp++;
//            }
//            if(strArray[i]=='A'){
//                res+=((countt%1000000007)*(countp%1000000007))%1000000007;
//            }
//        }

////        System.out.println(res);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}



