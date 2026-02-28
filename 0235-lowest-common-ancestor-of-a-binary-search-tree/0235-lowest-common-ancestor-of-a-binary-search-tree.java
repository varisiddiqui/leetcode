/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        find(root, p.val, path1);
        find(root, q.val, path2);

        int sz = Math.min(path1.size(), path2.size());
        int i=0;

        while(i<sz){
            if(path1.get(i).val != path2.get(i).val) break;

            i++;
        }
        return path1.get(i-1);
    }

    public void find(TreeNode root, int target, List<TreeNode> path){
        if(root.val == target){
            path.add(root);
            return;
        }

        path.add(root);

        if(root.val < target) find(root.right, target, path);
        else find(root.left, target, path);
    }
}