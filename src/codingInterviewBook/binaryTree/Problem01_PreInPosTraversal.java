package codingInterviewBook.binaryTree;

/**
 * Created by jc on 3/11/2017.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树的先序,中序,后序遍历
 * 非递归的做法
 */
public class Problem01_PreInPosTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return new ArrayList<>();
        }
        stack.push(root);
        TreeNode node=null;
        while (!stack.isEmpty()){
            node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        TreeNode cur=root;
        int flag=0;
        while (!stack.isEmpty()||cur!=null){
            flag=1;
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            list.add(node.val);
            cur=node.right;
        }
        return list;
    }



    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=null;
        node3.right=null;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;

        TreeNode node=null;

        System.out.println(new Problem01_PreInPosTraversal().inorderTraversal(node1));
    }
}
