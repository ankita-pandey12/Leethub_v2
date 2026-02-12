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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        q.add(root);
        q.add(null);
        map.put(1,root.val);
        int d=1;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                d++;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                map.put(d,curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        for(int k: map.values())
            ans.add(k);
        return ans;
    }
}