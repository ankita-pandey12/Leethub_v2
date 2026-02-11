/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
       if(check(root.left,root.right)==-1) 
            return false;
        return true;
    }

    public int check(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return 1;
        if(left==null || right==null)
            return -1;
        if(left.val!=right.val)
            return -1;
        if(check(left.left,right.right)==-1)
            return -1;
        if(check(left.right,right.left)==-1)
            return -1;
        return 1;
    }
}