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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        if (root == null)
            return ans;

        while (!st1.isEmpty() || curr != null) {

            if (curr != null) {
                while (curr != null) {
                    st1.push(curr);
                    curr = curr.left;
                }
            }
            else{
                TreeNode temp = st1.peek().right;
                if(temp == null){
                    temp = st1.peek();
                    st1.pop();
                    ans.add(temp.val);

                    while(!st1.isEmpty() && st1.peek().right == temp){
                        temp = st1.peek();
                        st1.pop();
                        ans.add(temp.val);
                    }

                }
                else{
                    curr = temp;
                }
            }

        }
        return ans;
    }
}