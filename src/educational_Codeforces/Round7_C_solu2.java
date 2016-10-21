package educational_Codeforces;

import java.io.*;

/**
 * Created by xgh on 2016/2/16.
 */
public class Round7_C_solu2 {
    private static Reader reader = null;
    private static Writer writer = null;

    public static void main(String[] args){
        reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);
        int arrayLength=getInt();
        int queryTimes=getInt();
        int[] array=new int[arrayLength];

        for(int i=0;i<arrayLength;i++){
            array[i]=getInt();
        }
        SegmentTree st=new SegmentTree(array,0,array.length-1);

        long[] res=new long[queryTimes];
        for(int i=0;i<queryTimes;i++){
            int left=getInt()-1;
            int right=getInt()-1;
            long x=getInt();
  //          int min=st.getMin(left,right);
            int maxPosi=st.getMax(array,left,right);
//            System.out.println(max);
            int minPosi=st.getMin(array,left,right);

            if(x==array[minPosi]&&x==array[maxPosi]){
                res[i]=-1;
            }else{
                if(x!=array[minPosi])
                    res[i]=minPosi+1;
                else
                    res[i]=maxPosi+1;
            }
        }
        for(int i=0;i<queryTimes;i++){
            System.out.println(res[i]);
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

class Node {
    public Node L, R;
    public int ValueL, ValueR;
    public int maxNum;
    public int minNum;
    public int maxPosition;
    public int minPosition;
    public Node(int left,int right){
        ValueL=left;
        ValueR=right;
    }
}

class SegmentTree{
    private Node root;
    public SegmentTree(int [] array,int left,int right){
        root=new Node(left,right);
        build(root,array,left,right);
    }
    public void build(Node node,int[] array,int left,int right){
        if(left==right){
            node.L=null;
            node.R=null;
            node.ValueL=left;
            node.ValueR=right;
            node.maxNum=((array[left]>array[right])?array[left]:array[right]);
            node.maxPosition=((array[left]>array[right])?left:right);
            node.minNum=((array[left]<array[right])?array[left]:array[right]);
            node.minPosition=((array[left]<array[right])?left:right);
            return ;
        }
        if(left==right-1){
            node.L=new Node(left,left);
            node.R=new Node(right,right);
            node.L.maxNum=array[left];
            node.L.minNum=array[left];
            node.L.maxPosition=left;
            node.L.minPosition=left;
            node.R.maxNum=array[right];
            node.R.minNum=array[right];
            node.R.maxPosition=right;
            node.R.minPosition=right;
            node.ValueL=left;
            node.ValueR=right;
            node.maxNum=((array[left]>array[right])?array[left]:array[right]);
            node.maxPosition=((array[left]>array[right])?left:right);
            node.minNum=((array[left]<array[right])?array[left]:array[right]);
            node.minPosition=((array[left]<array[right])?left:right);
            return ;
        }
        node.L=new Node(left,(left+right)>>1);
        node.R=new Node((left+right)>>1,right);
        build(node.L,array,left,(left+right)>>1);
        build(node.R,array,(left+right)>>1,right);
        node.ValueL=node.L.ValueL;
        node.ValueR=node.R.ValueR;
        node.maxNum=((node.L.maxNum>node.R.maxNum)?node.L.maxNum:node.R.maxNum);
        node.maxPosition=((node.L.maxNum>node.R.maxNum)?node.L.maxPosition:node.R.maxPosition);
        node.minNum=((node.L.minNum<node.R.minNum)?node.L.minNum:node.R.minNum);
        node.minPosition=((node.L.minNum<node.R.minNum)?node.L.minPosition:node.R.minPosition);
    }

    private int getMax(int[] array,Node node,int left,int right){
        int res=-1;
        if(left>node.ValueR||right<node.ValueL)
            return -1;
        if(left<=node.ValueL&&right>=node.ValueR){
            res=node.maxPosition;
            return res;
        }
        if(node.L==null)
            return -1;
        int p1=getMax(array,node.L,left,right);
        int p2=getMax(array,node.R,left,right);
        if(p1!=-1){
            if(p2!=-1){
                res=(array[p1]>array[p2]?p1:p2);
            }else
                res=p1;
        }else{
            if(p2!=-1){
                res=p2;
            }else
                res=-1;
        }
        return res;
    }
    public int getMax(int[] array,int left,int right){
        return getMax(array,root,left,right);
    }


    private int getMin(int[] array,Node node,int left,int right){
        int res=-1;
        if(left>node.ValueR||right<node.ValueL)
            return -1;
        if(left<=node.ValueL&&right>=node.ValueR){
            res=node.minPosition;
            return res;
        }
        if(node.L==null)
            return -1;
        int p1=getMin(array,node.L,left,right);
        int p2=getMin(array,node.R,left,right);
        if(p1!=-1){
            if(p2!=-1){
                res=(array[p1]<array[p2]?p1:p2);
            }else
                res=p1;
        }else{
            if(p2!=-1){
                res=p2;
            }else
                res=-1;
        }
        return res;
    }
    public int getMin(int[] array,int left,int right){
        return getMin(array,root,left,right);
    }
}

