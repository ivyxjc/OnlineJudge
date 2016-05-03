package leetcode.medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class No_112_Path_Num {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        if(root.left==null && root.right==null){
            if(root.val==sum){
                return true;
            }else {
                return false;
            }
        }
        return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
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

        System.out.print(hasPathSum(root,22));

    }
}
