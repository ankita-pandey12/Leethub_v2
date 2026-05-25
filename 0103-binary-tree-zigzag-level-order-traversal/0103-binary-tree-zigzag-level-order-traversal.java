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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ld = new ArrayList<>();
        helper(root,ld);
        return ld;
    }

    public void helper(TreeNode root, List<List<Integer>> ld){
        boolean flag = true;
        if(root==null)
            return;
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                ld.add(ls);
                flag=!flag;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
                 ls = new ArrayList<>();
            }
            else{
                if(!flag)
                    ls.add(0,curr.val);
                else ls.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
    }
}

