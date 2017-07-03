package xyz.ivyxjc.educational_Codeforces;

import java.io.*;

/**
 * Created by xgh on 2016/2/16.
 */
public class Round7_C_solu3 {
    private static Reader reader = null;
    private static Writer writer = null;
    public static void main(String[] args){
        //读取数据
        reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);
        int arrayLength=getInt();
        int queryTimes=getInt();
        int[] array=new int[arrayLength+1];
        for(int i=0;i<arrayLength;i++) {
            array[i] = getInt();
        }

        int[] diff=new int[arrayLength];
        //diff[arrayLength-1]=arrayLength;

        int tmpI=0;
        for(int j=tmpI+1;j<arrayLength;){
            if(array[j]==array[tmpI]) {
                j++;
                continue;
            }
            for(;tmpI<j;tmpI++){
                diff[tmpI]=j;
            }
        }
        diff[arrayLength-1]=arrayLength;
        for(int i=tmpI;i<arrayLength;i++){
            diff[i]=arrayLength;
        }
//        try{
//            if(tmpI==0){
//                for(int i=0;i<queryTimes;i++) {
//                    int left = getInt() - 1;
//                    int right = getInt() - 1;
//                    int x = getInt();
//                    if(x!=array[0])
//                        writer.write(1+"\n");
//                    else
//                        writer.write(-1+"\n");
//                }
//                writer.flush();
//                return;
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }


        try{
            for(int i=0;i<queryTimes;i++){
                int left=getInt()-1;
                int right=getInt()-1;
                int x=getInt();
                if(array[left]!=x){
                    writer.write((left+1)+"\n");
                    continue;
                }
                if(diff[left]>right){
                    writer.write((-1)+"\n");
                }else{
                    writer.write((diff[left]+1)+"\n");
                }
            }
            writer.flush();
        }catch (IOException e){




        }

    }

    public static int getInt() {
        int read;
        int res = 0;
        boolean isNegative = false;// 是不是负数
        try {
            while ((read = reader.read()) != -1) {
                if ((char) read == '-') {
                    res = 0;
                    isNegative = true;
                    break;
                } else if (isNumber((char) read)) {
                    res = read - '0';
                    break;
                }
            }
            while ((read = reader.read()) != -1) {
                char ch = (char) read;
                if (isNumber(ch)) {
                    res = res * 10 + (read - '0');
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (isNegative == true) {
            res = -1 * res;
        }
        return res;
    }

    public static boolean isBlank(char ch) {
        if (ch == '\r' || ch == '\n' || ch == ' ') {
            return true;
        }
        return false;
    }

    public static boolean isNumber(char ch) {
        if (ch <= '9' && ch >= '0') {
            return true;
        }
        return false;
    }
}


