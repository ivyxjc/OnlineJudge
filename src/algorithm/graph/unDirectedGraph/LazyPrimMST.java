package algorithm.graph.unDirectedGraph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class LazyPrimMST{
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedUndirectedGraph G){
        pq=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.compareTo(o2);
            }
        });
        marked=new boolean[G.V()];
        mst=new PriorityQueue<>();
        visit(G,0);
        while (!pq.isEmpty()){
            Edge e=pq.remove();
            int v=e.either();
            int w=e.other(v);
            if(marked[v]&&marked[w])
                continue;
            mst.add(e);
            if(!marked[v])
                visit(G,v);
            if(!marked[w])
                visit(G,w);
        }

    }


    private void visit(EdgeWeightedUndirectedGraph G, int v){
        marked[v]=true;
        for(Edge e:G.adj(v)){
            if(!marked[e.other(v)])
                pq.add(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double res=0.0;
        for(Edge e:mst){
             res+=e.weight();
        }
        return res;
    }
}
