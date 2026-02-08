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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        int row=0;
        int c=0;
        TreeMap<Integer, List<int[]>> tm = new TreeMap<>();

        preOrder(root, tm, row, c);

        Comparator<int[]> cmp = (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        };
        for(Integer col: tm.keySet()){
            List<int[]> li = tm.get(col);
            Collections.sort(li, cmp);
            List<Integer> addA = new ArrayList<>();
            for(int arr[]: li) addA.add(arr[0]);
            ans.add(addA);
        }

        return ans;



    }

    public void preOrder(TreeNode root,TreeMap<Integer, List<int[]>> tm, int row, int col){
        if(root == null) return;

        tm.putIfAbsent(col, new ArrayList<>());
        tm.get(col).add(new int[]{root.val, row, col});

        preOrder(root.left, tm, row+1, col-1);
        preOrder(root.right, tm, row+1, col+1);


    }
}