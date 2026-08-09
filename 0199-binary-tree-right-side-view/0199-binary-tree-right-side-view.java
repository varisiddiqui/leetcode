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
        if(root == null) return new ArrayList<>();

        List<Integer> li = new ArrayList<>();

        Map<Integer, Integer> hm = new HashMap<>();

        reversePre(root, 0, 0, hm);

        for(Integer key: hm.keySet()){
            li.add(hm.get(key));
        }

        return li;


    }

    public void reversePre(TreeNode root, int row, int col, Map<Integer, Integer> hm){
        if(root == null) return;

        hm.putIfAbsent(row, root.val);

        if(root.right != null) reversePre(root.right, row+1, col+1, hm);
        if(root.left != null) reversePre(root.left, row+1, col-1, hm);

        
    }
}