package xyz.ivyxjc.codeForces_div2;

import xyz.ivyxjc.algorithm.graph.directedGraph.BellmanFordSP;
import xyz.ivyxjc.algorithm.graph.directedGraph.DirectedEdge;
import xyz.ivyxjc.algorithm.graph.directedGraph.EdgeWeightedDirectedGraph;


import java.util.Scanner;

/**
 * Created by ivyxjc on 2016/9/23.
 */
public class CF372_D {
    public static int aa(){
        return 1;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int V=in.nextInt();
        int E=in.nextInt();
        int desiredShortestLength=in.nextInt();
        int startV=in.nextInt();
        int endV=in.nextInt();
        EdgeWeightedDirectedGraph graph=new EdgeWeightedDirectedGraph(V);
        for(int i=0;i<E;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            double weight=(double)in.nextInt();
            DirectedEdge edge1=new DirectedEdge(a,b,weight);
            DirectedEdge edge2=new DirectedEdge(b,a,weight);
            graph.addEdge(edge1);
            graph.addEdge(edge2);
        }
        BellmanFordSP sl=new BellmanFordSP(graph,0);
        double res=0;
        for(DirectedEdge e:sl.pathTo(2)){
            res+=e.weight();
        }
        System.out.print(res);
    }
}

