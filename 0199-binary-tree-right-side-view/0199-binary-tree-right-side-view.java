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
    static class Triple {
        TreeNode node;
        int row;
        int col;

        public Triple(TreeNode node, int r, int c){
            this.node = node;
            this.row = r;
            this.col = c;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        int c=0;

        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(root, 0, 0));

        TreeMap<Integer, PriorityQueue<int[]>> tm = new TreeMap<>();

        Comparator<int[]> cmp = (a, b) -> {
            return b[1]-a[1];
        };
        
        while(!q.isEmpty()){
            Triple top = q.remove();
            int row = top.row;
            int col = top.col;

            if(top.node.left != null) 
            q.add(new Triple(top.node.left, row+1, col-1));
            if(top.node.right != null)
            q.add(new Triple(top.node.right, row+1, col+1));

            tm.putIfAbsent(row, new PriorityQueue<>(cmp));
            tm.get(row).add(new int[]{col, c, top.node.val});
            c++;
        }

        for(Integer key: tm.keySet()) {
            int t[] = tm.get(key).peek();
            res.add(t[2]);
        }
        return res;
    }

}