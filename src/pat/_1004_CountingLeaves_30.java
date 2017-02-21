package pat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jc on 2/20/2017.
 */


class Node_t{
    int data;
    ArrayList<Node_t> children;
    int parent;

    public Node_t(){
        parent=-1;
    }

    public void setData(int data){
        this.data=data;
    }

    public void setParent(int parent){
        this.parent=parent;
    }

    public void setChildren(ArrayList<Node_t> children){
        this.children=children;
    }

}

public class _1004_CountingLeaves_30 {

    public static void process(Node_t root){
        if(root==null){
            return;
        }
        if(root.children==null){
            System.out.println(0);
            return;
        }
        ArrayList<ArrayList<Node_t>> arr=new ArrayList<ArrayList<Node_t>>();
        ArrayList<Node_t> tmp=new ArrayList<Node_t>();
        tmp.add(root);
        arr.add(tmp);
        ArrayList<Integer> res=new ArrayList<Integer>();
        int arrIndex=0;

        while(true){
            int count=0;
            int flag=0;
            int size=arr.get(arrIndex).size();
            ArrayList<Node_t> ttt=new ArrayList<Node_t>();
            for(Node_t i:arr.get(arrIndex)){
                if(i.children==null){
                    count++;
                }else{
                    for(Node_t j:i.children){
                        ttt.add(j);
                    }
                }
                if(size==count){
                    flag=1;
                }
            }
            arr.add(ttt);
            res.add(count);
            if(flag==1){
                break;
            }
            arrIndex+=1;
        }
        System.out.print(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            System.out.print(" "+res.get(i));
        }
    }
    
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        if(N==0){

        } else if(N==1){
            System.out.println(0);
        } else{
            Node_t[] tree=new Node_t[N+1];

            for (int i = 0; i < M; i++) {
                int parentData=in.nextInt();
                int childerNum=in.nextInt();
                ArrayList<Node_t> tmp=new ArrayList<Node_t>();
                for(int j=0;j<childerNum;j++){
                    int childData=in.nextInt();
                    if(tree[childData]==null){
                        tree[childData]=new Node_t();
                    }
                    tree[childData].setData(childData);
                    tree[childData].setParent(parentData);
                    tmp.add(tree[childData]);
                }
                if(tree[parentData]==null){
                    tree[parentData]=new Node_t();
                }
                tree[parentData].setData(parentData);
                tree[parentData].setChildren(tmp);
            }

            process(tree[1]);
        }


    }
}
