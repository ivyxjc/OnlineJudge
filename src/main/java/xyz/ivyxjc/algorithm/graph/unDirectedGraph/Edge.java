package xyz.ivyxjc.algorithm.graph.unDirectedGraph;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class Edge implements Comparable<Edge>{
    private int v;
    private int w;
    private final double weight;

    public Edge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public int either(){
        return v;
    }

    public int other(int one){
        if(one==v){
            return w;
        }else {
            return v;
        }
    }

    public double weight(){
        return weight;
    }


    @Override
    public int compareTo(Edge o) {
        if(this.weight>o.weight())
            return 1;
        if(this.weight()<o.weight)
            return -1;
        return 0;
    }


}
