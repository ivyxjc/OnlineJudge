package xyz.ivyxjc.algorithm.graph.directedGraph;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public double weight(){
        return weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return to();
    }

}
