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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if(root.val == key){
            if(root.right == null && root.left == null) return null;

            if(root.right == null) return root.left;

            if(root.left == null) return root.right;

            TreeNode attach = root.right;
            while(attach.left != null){
                attach = attach.left;
            } 
            attach.left = root.left;
            return root.right;

            
        }
        

        boolean found=false;

        TreeNode dup = root;
        TreeNode par = root;
        while(dup != null){
            
            if(dup.val == key){
                found = true;
                break;
            }
            par = dup;

            if(dup.val < key) dup=dup.right;
            else dup = dup.left;
        }

        if(found){
            if(par.left == dup){
                if(dup.left == null && dup.right == null){
                    par.left = null;
                    return root;
                }

                if(dup.left == null || dup.right == null){
                    if(dup.left != null){
                        par.left = dup.left;
                        return root;
                    }
                    else{
                        par.left = dup.right;
                        return root;
                    }
                }

                TreeNode attach = dup.left;

                while(attach.right != null){
                    attach = attach.right;
                }
                attach.right = dup.right;
                par.left = dup.left;
                return root;
            }

            else{
                if(dup.left == null && dup.right == null){
                    par.right = null;
                    return root;
                }

                if(dup.left == null || dup.right == null){
                    if(dup.left != null){
                        par.right = dup.left;
                        return root;
                    }
                    else{
                        par.right = dup.right;
                        return root;
                    }
                }

                TreeNode attach = dup.right;
                while(attach.left != null) attach = attach.left;

                attach.left = dup.left;

                par.right = dup.right;
                return root;










            }





        }
        return root;
    }
}