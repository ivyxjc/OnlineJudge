package graph.directedGraph;

import graph.Bag;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class EdgeWeightedDirectedGraph {
    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDirectedGraph(int V){
        this.V=V;
        this.E=0;
        adj=new Bag[V];
        for(int i=0;i<V;i++){
            adj[i]=new Bag<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Bag<DirectedEdge>[] getAdj() {
        return adj;
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag=new Bag<>();
        for(int i=0;i<V;i++){
            for(DirectedEdge e:adj[i]){
                bag.add(e);
            }
        }
        return bag;
    }
}
