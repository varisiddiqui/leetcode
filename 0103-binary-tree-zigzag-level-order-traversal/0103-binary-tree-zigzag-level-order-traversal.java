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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<Integer> li = new ArrayList<>();

        char ch = 'L';

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                TreeNode curr = q.remove();
                li.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(ch == 'L'){
                ans.add(new ArrayList<>(li));
                ch = 'R';
            }
            else{
                Collections.reverse(li);
                ans.add(new ArrayList<>(li));
                ch = 'L';
            }
            li.clear();
            

        }

        return ans;

    }
}