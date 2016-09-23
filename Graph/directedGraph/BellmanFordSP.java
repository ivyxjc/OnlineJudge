package Graph.directedGraph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDirectedGraph G,int s){
        distTo=new double[G.V()];
        edgeTo=new DirectedEdge[G.V()];
        onQ=new boolean[G.V()];
        queue=new PriorityQueue<>();
        for(int i=0;i<G.V();i++){
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        distTo[s]=0.0;
        queue.add(s);
        onQ[s]=true;
        while (!queue.isEmpty()&&!hasNegativeCycle()){
            int v=queue.poll();
            onQ[v]=false;
            relax(G,v);
        }

    }
    private void relax(EdgeWeightedDirectedGraph G,int v){
        for(DirectedEdge e:G.adj(v)){
            int w=e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
                if(onQ[w]){
                    queue.add(w);
                    onQ[w]=true;
                }
            }

            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }
    public boolean hasNegativeCycle(){
        return false;
    }

    private void findNegativeCycle(){

    }

    public Iterable<DirectedEdge> pathTo(int v){
        Stack<DirectedEdge> path=new Stack<>();
        for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }
}
