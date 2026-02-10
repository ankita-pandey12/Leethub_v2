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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        level(root,ls);
        return ls;
    }

    public void level(TreeNode root,List<List<Integer>> ls){
        if(root==null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> ld = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                ls.add(ld);
                ld=new ArrayList<>();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                ld.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
    }
}