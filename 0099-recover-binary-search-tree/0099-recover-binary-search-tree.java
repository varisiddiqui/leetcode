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
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        List<Integer> in = new ArrayList<>();
        inorder(root, in);

        Collections.sort(in);
        System.out.println(in);

        ind(root, in, new int[]{0});
    }

    public void ind(TreeNode root, List<Integer> in, int idx[]){
        if(root == null) return;

        ind(root.left, in, idx);
        if(in.get(idx[0]) != root.val){
            root.val=in.get(idx[0]);
        }
        idx[0]++;
        ind(root.right, in, idx);
    }



    
    public void inorder(TreeNode root, List<Integer> in){
        if(root == null) return;

        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
}