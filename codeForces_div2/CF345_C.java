package codeForces_div2;

import java.io.*;

/**
 * Created by jc on 3/7/2016.
 */
public class CF345_C {
    private static Reader reader = null;
    private static Writer writer = null;
    public static void main(String[] args) {
        //读取数据
        reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);
        int pointsNum = getInt();
        int [] xScale=new int[pointsNum];
        int[] yScale=new int[pointsNum];
        for(int i=0;i<pointsNum;i++){
            xScale[i]=getInt();
            yScale[i]=getInt();
        }

        sort(xScale,yScale,0,pointsNum-1);
        for(int i=0;i<pointsNum;i++){
            System.out.print(xScale[i]+" ");
            System.out.println(yScale[i]);
        }
        for(int i=0;i<pointsNum;i++){

        }

    }

    public static void sort(int [] a,int []b,int lo,int hi){
        if(hi<=lo)
            return;
        int j=partition(a,b,lo,hi);
        sort(a,b,j+1,hi);
    }

    public static int partition(int[] a,int[] b,int lo ,int hi){
        int i=lo;
        int j=hi+1;
        Comparable v=a[lo];
        while(true){
            while(v.compareTo(a[++i])>0){
                if(i==hi)
                    break;
            }
            while(v.compareTo(a[--j])<0){
                if(j==lo)
                    break;
            }
            if(i>=j)
                break;
            exch(a,i,j);
            exch(b,i,j);
        }
        exch(a,lo,j);
        exch(b,lo,j);
        return j;
    }

    public static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
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
