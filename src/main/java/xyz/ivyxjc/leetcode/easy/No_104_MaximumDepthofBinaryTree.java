package xyz.ivyxjc.leetcode.easy;

/**
 * Created by jc on 4/26/2016.
 */

/**
 * difficulty:3
 */


/**
 * 寻找二叉树最长路径
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class No_104_MaximumDepthofBinaryTree {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else if(root.left!=null&& root.right!=null){
            return max(1+maxDepth(root.left),1+maxDepth(root.right));
        }else if(root.left==null){
            return 1+maxDepth(root.right);
        }else{
            return 1+maxDepth(root.left);
        }
    }



    public int max(int a,int b){
        return (a>b?a:b);
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);

        root.left.left=new TreeNode(11);
        root.left.right=null;
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right=new TreeNode(8);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.left.right=new TreeNode(1);
        root.left.left.left.left=null;
        root.left.left.left.right=null;
        root.left.left.right.left=null;
        root.left.left.right.right=null;
        root.right.left.right.left=null;
        root.right.left.right.right=null;
        root.right.right.left=null;
        root.right.right.right=null;

        No_104_MaximumDepthofBinaryTree test=new No_104_MaximumDepthofBinaryTree();
        System.out.println(test.maxDepth(root));
    }
}
