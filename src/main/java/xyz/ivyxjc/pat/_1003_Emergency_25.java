package xyz.ivyxjc.pat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jc on 2/29/2016.
 */
public class _1003_Emergency_25 {


    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int numOfCity=in.nextInt();
        int numOfRoad=in.nextInt();
        int starLocation=in.nextInt();
        int destination=in.nextInt();
        EdgeWeightedGraph graph=new EdgeWeightedGraph(numOfCity);
        for(int i=0;i<numOfCity;i++){
            graph.setNumOfEmergencyTeam(i,in.nextInt());
        }
        for(int i=0;i<numOfRoad;i++){
            graph.addEdge(new Edge(in.nextInt(),in.nextInt(),in.nextInt()));
        }

    }
}
class Edge{
    private int v;
    private int w;
    private int weight;

    public Edge(int v,int w,int weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public int Weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int i){
        if(i==v){
            return w;
        }else{
            return v;
        }
    }
}

class EdgeWeightedGraph{
    private int[] numOfEmergencyTeam;
    private int V;
    private int E;
    private boolean [] marked;
    private ArrayList<Edge>[] adj;

    public EdgeWeightedGraph(int N){
        this.V=V;
        this.E=0;
        marked=new boolean[N];
        numOfEmergencyTeam=new int[N];
        adj=new ArrayList[N];
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

    public void setNumOfEmergencyTeam(int v,int numOfTeams){
        numOfEmergencyTeam[v]=numOfTeams;
    }

    public void dfs(int s){
        for(Edge e:adj(s)){
            int v=e.other(s);
            marked[v]=true;
            dfs(v);
            marked[v]=true;
        }
    }


}
