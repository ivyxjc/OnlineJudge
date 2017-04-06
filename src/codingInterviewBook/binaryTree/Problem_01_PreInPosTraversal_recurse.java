package codingInterviewBook.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jc on 3/11/2017.
 */


/**
 * 二叉树的先序,中序,后序遍历
 * 递归的解法
 */
public class Problem_01_PreInPosTraversal_recurse {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    void preOrder(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    void inOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }


    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    void postOrder(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }
        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.val);
    }

    public static void main(String[] args){

    }
}
