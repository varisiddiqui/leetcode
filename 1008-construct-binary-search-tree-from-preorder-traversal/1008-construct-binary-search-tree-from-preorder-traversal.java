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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        if(n == 1) return new TreeNode(preorder[0]);

        int inorder[] = new int[n];
        for(int i=0; i<n; i++) inorder[i]= preorder[i];

        Arrays.sort(inorder);


        HashMap<Integer, Integer> hm = new HashMap<>();

        
        
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);

        if(preorder.length == 1) return new TreeNode(preorder[0]);

        TreeNode root = buildTree(inorder, preorder, hm, 0, n-1, 0, n-1);
        return root;

       
        
        

    }

    public TreeNode buildTree(int inorder[], int preorder[], HashMap<Integer, Integer> hm, int stPre, int endPre , int stIn, int endIn){
        if(stPre > endPre || stIn > endIn) return null;


        TreeNode root = new TreeNode(preorder[stPre]);

        int currIdx = hm.get(preorder[stPre]);

        int leftSz = currIdx - stIn;
        
        root.left = buildTree(inorder, preorder, hm, stPre+1, stPre+leftSz, stIn, currIdx-1);

        root.right = buildTree(inorder, preorder, hm, stPre+leftSz+1, endPre, currIdx+1, endIn);

        return root;
    }
}