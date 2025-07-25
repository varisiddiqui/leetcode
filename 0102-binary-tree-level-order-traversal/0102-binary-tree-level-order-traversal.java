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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        return result;

        //Queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> li = new ArrayList<>();
        
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            
            if(node == null){
                result.add(li);
                li = new ArrayList<>();
                if(q.isEmpty())
                break;
                else{
                    q.add(null);
                }
            }

            else{
                if(node.left != null)
                q.add(node.left);

                if(node.right != null)
                q.add(node.right);

                li.add(node.val);
            }
        }

        return result;

    }


}