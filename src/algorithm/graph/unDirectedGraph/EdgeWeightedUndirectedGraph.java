package algorithm.graph.unDirectedGraph;

import algorithm.graph.Bag;

/**
 * Created by ivyxjc on 2016/9/23.
 */
public class EdgeWeightedUndirectedGraph {

    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<Edge>[] adj;

    public EdgeWeightedUndirectedGraph(int V){
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

    public void addEdge(Edge e){
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }
}



