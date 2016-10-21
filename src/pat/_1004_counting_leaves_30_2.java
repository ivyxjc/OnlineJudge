package pat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xgh on 2016/2/26.
 */
//  20分/30分

class Node2{
    private int data;
    private ArrayList<Node2> childern;//相邻子节点的ArrayList
    private int depth;

    public Node2(int data){
        childern=new ArrayList<>();
        this.data=data;
    }

    public void setDepth(int depth){
        this.depth=depth;
    }

    public int getDepth(){
        return depth;
    }

    public void addChild(Node2 child){
        childern.add(child);
    }

    public ArrayList<Node2> getChildern(){
        return childern;
    }

    public int getData(){
        return data;
    }
}

public class _1004_counting_leaves_30_2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        Node2[] tree=new Node2[N+1];
        int maxDepth=0;
        tree[1]=new Node2(1);
        tree[1].setDepth(0);
        for(int i=0;i<M;i++){
            int parentData=in.nextInt();
            int childerNum=in.nextInt();
            for(int j=0;j<childerNum;j++){
                int childData=in.nextInt();
                tree[childData]=new Node2(childData);
                tree[childData].setDepth(tree[parentData].getDepth()+1);
                tree[parentData].addChild(tree[childData]);
                maxDepth=(maxDepth>tree[parentData].getDepth()?maxDepth:tree[parentData].getDepth());
            }
        }

        int []res=new int[maxDepth+2] ;
        for(int i=1;i<N+1;i++){
            if(tree[i].getChildern().size()==0){
                res[tree[i].getDepth()]++;
            }
        }
        System.out.print(res[0]);
        for(int i=1;i<maxDepth+2;i++){
            System.out.print(" "+res[i]);
        }
    }

}
