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
        List<List<Integer>> li = new ArrayList<>();
        int f=1;
        if(root == null) return li;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode top = q.remove();

            if(top == null){
                if(q.isEmpty()){
                    if(f == 0)
                    Collections.reverse(res);
                    li.add(res);
                    break;
                } 
                q.add(null);
                if(f == 0){
                     Collections.reverse(res);
                     f=1;
                }
                else{
                    f=0;
                }
                
               
                li.add(res);
                res = new ArrayList<>();

                
            }

            else{
                   res.add(top.val);
                    if(top.left != null)
                    q.add(top.left);
                    if(top.right != null)
                    q.add(top.right);                                  
            }
     
        }
        return li;
    }
}