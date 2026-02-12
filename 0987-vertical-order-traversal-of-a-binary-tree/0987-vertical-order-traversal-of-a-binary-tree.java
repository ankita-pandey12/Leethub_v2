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
import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0, 0});

        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode n = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, n.val});

            if (n.left != null)
                q.add(new Object[]{n.left, row + 1, col - 1});

            if (n.right != null)
                q.add(new Object[]{n.right, row + 1, col + 1});
        }
        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });
            List<Integer> colList = new ArrayList<>();
            for (int[] p : list)
                colList.add(p[1]);
            ans.add(colList);
        }
        return ans;
    }
}
