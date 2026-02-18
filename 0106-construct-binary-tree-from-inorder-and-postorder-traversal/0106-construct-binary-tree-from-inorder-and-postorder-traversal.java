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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
 
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) hm.put(inorder[i], i);
        return child(hm, postorder, inorder, 0, n-1, 0, n-1);
    }


    public TreeNode child(HashMap<Integer, Integer> hm, int post[], int in[], int stIn, int endIn, int stPost, int endPost){
        int currE = post[endPost];
        if(stIn == endIn) return new TreeNode(currE);
        else if(stIn > endIn) return null;

        int currIdx = hm.get(currE);

        TreeNode curr = new TreeNode(currE);

        //int leftSz = currIdx-stIn;
        int rightSz = endIn - currIdx;
        int n =  post.length;
        
        if(endPost-rightSz-1 >=0 )
        curr.left = child(hm, post, in, stIn, currIdx-1, stPost, endPost-rightSz-1);

        if( endPost-rightSz >=0)
        curr.right = child(hm, post, in, currIdx+1, endIn, endPost-rightSz, endPost-1);

        return curr;
    }


}