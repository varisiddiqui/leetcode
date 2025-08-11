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
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        if(root == null)
        return res;

        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp != null){
                    curr = temp;
                }
                else{
                    temp = st.peek();
                    res.add(st.pop().val);
                    while(!st.isEmpty() && st.peek().right == temp){
                        temp = st.peek();
                        res.add(st.pop().val);
                    }
                }
            }
        }
        return res;
    }
}