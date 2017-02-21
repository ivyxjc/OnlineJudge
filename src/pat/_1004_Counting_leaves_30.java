package pat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xgh on 2016/2/25.
 */
class Node{
    private int data;
    private ArrayList<Node> childern;//相邻子节点的ArrayList
    private int depth;

    public Node(int data){
        childern=new ArrayList<>();
        this.data=data;
    }

    public void setDepth(int depth){
        this.depth=depth;
    }

    public int getDepth(){
        return depth;
    }

    public void addChild(Node child){
        childern.add(child);
    }

    public ArrayList<Node> getChildern(){
        return childern;
    }

    public int getData(){
        return data;
    }

}

class Tree{
    private Node root;

    public Tree(){

    }
    public Tree(Node root){
        this.root=root;
    }
    public void addChild(Node parent,Node child){
        parent.addChild(child);
        child.setDepth(parent.getDepth()+1);
    }

    public  Node search(Node node,int data){
        Node tmp=node;
        if(tmp.getData()==data){
            return tmp;
        }
        if(tmp.getChildern()!=null){
            for(Node e:tmp.getChildern()){
                Node nodeTmp= search(e,data);
                if(nodeTmp!=null)
                    return nodeTmp;
            }
        }

        return null;
    }


    public Node getRoot(){
        return root;
    }
}

public class _1004_Counting_leaves_30 {

    private static int[] res;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        in.nextLine();
        int maxDepth=0;
        Tree tree=new Tree(new Node(in.nextInt()));
        tree.getRoot().setDepth(0);
        int j_maxTmp=in.nextInt();
        for(int j=0;j<j_maxTmp;j++){
            tree.addChild(tree.getRoot(),new Node(in.nextInt()));
            //maxDepth=(maxDepth>root.getDepth()?maxDepth:root.getDepth());
        }

//        if(N==0)
//            System.exit(0);
//        if(N==1){
//            System.out.println(0);
//            return;
//        }
        for(int i=1;i<M;i++){
//            String tmp=in.nextLine();
//            String[] buildData=tmp.split(" ");
            Node node=tree.search(tree.getRoot(),in.nextInt());
            maxDepth=(maxDepth>node.getDepth()?maxDepth:node.getDepth());
            int j_max=in.nextInt();
            for(int j=0;j<j_max;j++){
                tree.addChild(node,new Node(in.nextInt()));
            }
        }

        maxDepth=maxDepth+1;
        res=new int[maxDepth+1];
        Node root=tree.getRoot();

        solve(root);


        System.out.print(res[0]);
        for(int i=1;i<maxDepth+1;i++){
            System.out.print(" "+res[i]);
        }


    }

    public static void solve(Node node){
        if(node.getChildern().size()==0){
            res[node.getDepth()]++;
        }else{
            for(Node e:node.getChildern()){
                solve(e);
            }
        }
    }
}
