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
    public void insert(TreeNode root, int v){
        while(true){
            if(root.val < v){
                if(root.right==null){
                    TreeNode n = new TreeNode(v);
                    root.right = n;
                    break;
                }
                root=root.right;
            }
            else{
                if(root.left==null){
                    TreeNode n = new TreeNode(v);
                    root.left = n;
                    break;
                }
                root=root.left;
            }
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0)
            return null;
        TreeNode curr = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            insert(curr,preorder[i]);
        }
        return curr;
    }
}