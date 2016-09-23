


package Educational_Codeforces;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by xgh on 2016/2/16.
 */
public class Round7_E {
    private static Reader reader = null;
    private static Writer writer = null;

    public static void main(String[] args){
//        EdgeWeightedUndirectedGraph G=new EdgeWeightedUndirectedGraph(2,1);
//        G.addEdge(2,1);
//        G.addEdge(1,2);
//        G.addEdge(1, 3);
//        G.addEdge(1,4);
//        G.addEdge(2, 5);
//        G.addEdge(2 ,6);
//        G.addEdge(3 ,7);
//        G.addEdge(3 ,8);
//        G.addEdge(3, 9);
//        G.addEdge(8 ,10);
//        G.addEdge(8, 11);
//        G.addEdge(8 ,12);
        reader = new InputStreamReader(System.in);
        writer = new OutputStreamWriter(System.out);

        int V=getInt();
        Graph G=new Graph(V,V-1);
        for(int i=0;i<V-1;i++){
            G.addEdge(getInt(),getInt());
        }
        G.dfs();
        G.solve();
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



class GraphNode{
    private int degree;
    private ArrayList<Integer> connectedvertexs;
    private int depth;
    public GraphNode(){
        connectedvertexs=new ArrayList<>();
    }
    public ArrayList<Integer> getConnectedvertexs() {
        return connectedvertexs;
    }

    public void addConnectedvertex(int connectedvertex) {
        connectedvertexs.add(connectedvertex);
        degree++;
    }


    public int getDegree(){
        return degree;
    }

    public void degreeAddOne(){
        degree++;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

}

class Graph{
    private int V;
    private int E;
    private GraphNode[] adj;
    private boolean[] marked;
    private int depth=0;
    private ArrayList<Integer>[] depthArray;
    private int count=0;

    public Graph(int V,int E){
        this.V=V;
        this.E=E;
        adj=new GraphNode[V+1];
        for(int i=1;i<=V;i++){
            adj[i]=new GraphNode();
        }
        marked=new boolean[V+1];
    }

    public void addEdge(int v,int w){
        adj[v].addConnectedvertex(w);
        adj[w].addConnectedvertex(v);
    }

//dfs()的目的是将根节点的每个直接子节点的所有叶子节点的深度
//存储在一个ArrayList中组成一个数组。
    public void dfs(int v){
        if(v==1){
            int rootSonsNum=adj[v].getConnectedvertexs().size();
            depthArray=new ArrayList[rootSonsNum];
            for(int i=0;i<rootSonsNum;i++){
                depthArray[i]=new ArrayList<>();
            }
        }
        marked[v]=true;
        adj[v].setDepth(depth);
        if(adj[v].getDegree()==1)
            depthArray[count].add(adj[v].getDepth());
        depth++;
        for(Integer i:adj[v].getConnectedvertexs()){
            if(!marked[i]){
                dfs(i);
                depth--;
            }
            if(v==1){
                count++;
            }
        }
    }
//
//    private boolean inArrayList(Integer x,ArrayList<Integer> al){
//        for(Integer i:al){
//            if(i==x){
//                return true;
//            }
//        }
//        return false;
//    }

    public void dfs(){
        dfs(1);
    }

    public int solve(){
        for(ArrayList<Integer> i:depthArray) {
            Collections.sort(i);
//            i.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    if (o1 > o2)
//                        return 1;
//                    else if (o1 == o2)
//                        return 0;
//                    else
//                        return -1;
//                }
//            });
        }
        int res=0;
        for(ArrayList<Integer> i:depthArray){
            //System.out.println(i);
            int tmpres=i.get(0);
            int tmpIndex=1;
            while(tmpIndex<i.size()){
                tmpres=max(tmpres+1,i.get(tmpIndex));
                tmpIndex++;
            }
            res=max(tmpres,res);
        }
        System.out.println(res);
        return res;
    }

    private int max(int i,int j){
        if(i>j)
            return i;
        else
            return j;
    }
}
