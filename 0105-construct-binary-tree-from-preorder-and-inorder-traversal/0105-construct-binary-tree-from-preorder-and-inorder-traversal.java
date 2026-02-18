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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
 
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(inorder[i], i);
        return child(hm, preorder, inorder, 0, n-1, 0, n-1);


    }

    public TreeNode child(HashMap<Integer, Integer> hm, int pre[], int in[], int stIn, int endIn, int stPre, int endPre){
        int currE = pre[stPre];
        if(stIn == endIn) return new TreeNode(currE);
        else if(stIn > endIn) return null;

        int currIdx = hm.get(currE);

        TreeNode curr = new TreeNode(currE);

        int leftSz = currIdx-stIn;
        int n =  pre.length;
        
        if(stPre+1 <n)
        curr.left = child(hm, pre, in, stIn, currIdx-1, stPre+1, stPre+leftSz);

        if(stPre+leftSz+1 < n)
        curr.right = child(hm, pre, in, currIdx+1, endIn, stPre+leftSz+1, endPre);

        return curr;




        
    }
}