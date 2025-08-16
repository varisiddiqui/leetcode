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
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root == null)
            return res;

        q.add(root);
        q.add(null);

        List<Integer> li = new ArrayList<>();

        char flag = 'R';//reverse add kroge stack me

        while (!q.isEmpty() || !st.isEmpty()) {
            TreeNode top = q.remove();

            if (top == null) {
                res.add(li);

               
                

                li = new ArrayList<>();
                if (st.isEmpty()) {
                
                    break;
                }

                while (!st.isEmpty()) {
                    q.add(st.pop());
                }
                
                if (flag == 'R')
                    flag = 'L';
                else
                    flag = 'R';

                q.add(null);
            }

            else {
                

                li.add(top.val);
                //flag = R insert left on stack first
                if (flag == 'R') {
                    if (top.left != null)
                        st.push(top.left);
                    if (top.right != null)
                        st.push(top.right);
                }

                //flag = L insert right on stack first
                if (flag == 'L') {
                    if (top.right != null)
                        st.push(top.right);
                    if (top.left != null)
                        st.push(top.left);
                }

            }

        }

        return res;

    }
}