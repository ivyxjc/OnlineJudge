package xyz.ivyxjc.leetcode.easy;

import java.util.ArrayList;

/**
 * Created by jc on 4/26/2016.
 */
public class No_100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }

        if(p.val==q.val){
            return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
        }

        return false;

    }

    /**
     * 求先序遍历 和本题无关，以下皆与本题无关
     * @param p
     * @param array
     */
    private void preorderTraversal(TreeNode p,ArrayList array){
        if(p.left!=null&&p.right!=null){
            array.add(p.val);
            preorderTraversal(p.left,array);
            preorderTraversal(p.right,array);
            return;
        }
        if(p.left==null&&p.right==null){
            array.add(p.val);
            return;
        }
        if(p.left!=null){
            array.add(p.val);
            preorderTraversal(p.left,array);
            return;
        }
        if(p.right!=null){
            array.add(p.val);
            preorderTraversal(p.right,array);
            return;
        }
    }

    public ArrayList preorderTraversal(TreeNode p){
        ArrayList list=new ArrayList();
        preorderTraversal(p,list);
        return list;
    }

    private void  inorderTraversal(TreeNode p,ArrayList array){
        if(p.left!=null&&p.right!=null){
            inorderTraversal(p.left,array);
            array.add(p.val);
            inorderTraversal(p.right,array);
            return;
        }
        if(p.left==null&&p.right==null){
            array.add(p.val);
            return;
        }
        if(p.left!=null){
            inorderTraversal(p.left,array);
            array.add(p.val);
            return;
        }
        if(p.right!=null){
            array.add(p.val);
            inorderTraversal(p.right,array);
            return;
        }
    }

    public ArrayList inorderTraversal(TreeNode p){
        ArrayList list=new ArrayList();
        inorderTraversal(p,list);
        return list;
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


        TreeNode root2=new TreeNode(5);
        root2.left=new TreeNode(4);

        root2.left.left=new TreeNode(11);
        root2.left.right=null;
        root2.left.left.left=new TreeNode(7);
        root2.left.left.right=new TreeNode(2);
        root2.right=new TreeNode(8);
        root2.right.left=new TreeNode(13);
        root2.right.right=new TreeNode(4);
        root2.right.left.right=new TreeNode(1);
        root2.left.left.left.left=null;
        root2.left.left.left.right=null;
        root2.left.left.right.left=null;
        root2.left.left.right.right=null;
        root2.right.left.right.left=null;
        root2.right.left.right.right=null;
        root2.right.right.left=null;
        root2.right.right.right=null;

        No_100_SameTree test=new No_100_SameTree();
//        ArrayList res=test.inorderTraversal(root);
//
//        for(int i=0;i<res.size();i++){
//            System.out.println(res.get(i));
//        }
        System.out.println(test.isSameTree(root,root2));
    }

}
