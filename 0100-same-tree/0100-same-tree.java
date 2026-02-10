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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(check(p,q)==-1)
            return false;
        return true;        
    }

    public int check(TreeNode p,TreeNode q){
        if (p == null && q == null)
            return 1;
        if((p==null && q!=null) || (p!=null && q==null))
            return -1;
        if(p.val!=q.val)
            return -1;
        if(check(p.left,q.left)==-1)
            return -1;
        if(check(p.right,q.right)==-1)
            return -1;
        return 0;
    }
}