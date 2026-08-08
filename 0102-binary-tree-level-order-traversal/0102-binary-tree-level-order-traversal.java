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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
     

        level(root, q);
        return ans;
    }

    public void level(TreeNode root, Queue<TreeNode> q) {
        if (root == null)
            return;

        List<Integer> li = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

            }

            ans.add(new ArrayList<>(li));
            li.clear();
            
            
        }

    }
}