package codeforces_problemset01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * Created by yanjiusuo4 on 2016/10/20.
 */
public class _580C_Kefa_and_Park{


    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n=nextInt();
        int m=nextInt();
        int[] cats=new int[n];

        Tree tree=new Tree(n,n-1);

        for(int i=0;i<n;i++) {
            cats[i]=nextInt();
        }

        for(int i=0;i<n-1;i++) {
            tree.addEdge(nextInt()-1,nextInt()-1);
        }


        DFS dfs=new DFS(tree,cats);

        int res=0;


//        if(dfs.res()==null){
//            System.out.println("null");
//        }
//        return;
        for(int i=0;i<dfs.res().size();i++){
            System.out.println(dfs.res().get(i).v);
            if(dfs.res().get(i).pathCats>m){
                System.out.println(dfs.res().get(i).v);
                res+=1;
            }
        }

        System.out.println(res);





    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
}

//class Edge{
//    int v;
//    int w;
//
//    public Edge(int i,int j){
//        v=i;
//        w=j;
//    }
//
//    public int either(){
//        return v;
//    }
//
//    public int other(int one){
//        if(one==v){
//            return w;
//        }else {
//            return v;
//        }
//    }
//}

class Tree{
    HashSet<Integer>[] tree;
    int V;
    int E;

    public Tree(int V,int E){
        this.V=V;
        this.E=E;
        tree=new HashSet[V];
    }

    public void addEdge(int v,int w){
        if(tree[v]==null){
            tree[v]=new HashSet<>();
        }
        if(tree[w]==null){
            tree[w]=new HashSet<>();
        }
        tree[v].add(w);
        tree[w].add(v);
    }

    public int root(){
        return 0;
    }

    public int V(){
        return V;
    }

    public Iterable<Integer> adj(int v){
        return tree[v];
    }
}

class Map{
    public int v;
    public int pathCats;
    public Map(int v,int pathCats){
        this.v=v;
        this.pathCats=pathCats;
    }
}

class DFS{
    private Tree tree;
    private int[] cats;
    private int[] marked;
    private ArrayList<Map> res;

    public DFS(Tree tree,int [] cats){
        this.tree=tree;
        this.cats=cats;
        res=new ArrayList<>();

        marked=new int[tree.V()];
        for(int i=0;i<tree.V();i++){
            marked[i]=-1;
        }

        if(cats[0]==1){
            dfs(0,1);
            marked[0]=1;
        }else{
            dfs(0,0);
            marked[0]=0;
        }
    }

    public int[] marked(){
        return marked;
    }

    public ArrayList<Map> res(){
        return res;
    }

    public void dfs(int v,int pathCats){
        marked[v]=pathCats;
        if(tree.adj(v)==null){
            res.add(new Map(v,pathCats));
        }
        for (int i:tree.adj(v)){
            if(marked[i]==-1){
                if(cats[i]==1){
                    dfs(i,pathCats+1);
                }else if(cats[i]==0){
                    dfs(i,pathCats);
                }
            }
        }
    }
}
