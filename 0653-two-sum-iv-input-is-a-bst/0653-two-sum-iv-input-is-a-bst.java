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
    boolean ans = false;
    HashMap<Integer,Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        find(root,k);
        return ans;
    }

    public void find(TreeNode root,int k){
        if(root==null)
            return;
        else if(map.containsKey(k-root.val)){
            ans=true;
            return;
        }
        else
            map.put(root.val,map.getOrDefault(root.val,0)+1);
        find(root.left,k);
        find(root.right,k);
    }
}