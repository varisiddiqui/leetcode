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
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        TreeMap<Integer, List<int[]>> tm = new TreeMap<>();

        int r =0;
        int col = 0;

        postOrder(tm, root, r, col);

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[1], a[1]);
        };

        for(Integer row: tm.keySet()){
            
            ans.add(tm.get(row).get(0)[0]);
        }


        return ans;

    }

    public void postOrder(TreeMap<Integer, List<int[]>> tm, TreeNode root, int row, int col){
        if(root == null) return;

        tm.putIfAbsent(row, new ArrayList<>());

        tm.get(row).add(new int[]{root.val, col});

        postOrder(tm, root.right, row+1, col+1);
        postOrder(tm, root.left, row+1, col-1);
    }
}