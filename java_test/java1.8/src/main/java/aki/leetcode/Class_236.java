package aki.leetcode;

import java.util.*;

public class Class_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==q||root==p){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftLowest = lowestCommonAncestor(left,p,q);
        TreeNode rightLowest = lowestCommonAncestor(right,p,q);
        if(leftLowest != null && rightLowest != null){
            return root;
        }
        if(leftLowest != null){
            return leftLowest;
        }
        return rightLowest;
    }
}
