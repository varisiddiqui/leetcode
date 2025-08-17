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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
        return res;

        

        Map<TreeNode, Integer> col = new HashMap<>();
        Map<TreeNode, Integer> row = new HashMap<>();
        col.put(root, 0);
        row.put(root, 0);
        assignCol(root, col, row);

        Map<Integer, List<int[]>> hm = new TreeMap<>();



        for(TreeNode key: col.keySet()){
            int column = col.get(key);
            int r = row.get(key);
            int val = key.val;

            hm.putIfAbsent(column, new ArrayList<>());
            hm.get(column).add(new int[]{r, val});           
            
        }

        for(Integer c: hm.keySet()){
            List<int[]> li = hm.get(c);
            Collections.sort(li, (a, b) -> {
                if(a[0] != b[0]) return a[0]-b[0];
                else return a[1]-b[1];
            });

            List<Integer> ans = new ArrayList<>();
            for(int a[] : li){
                ans.add(a[1]);
            }
            res.add(ans);
        }
  
       

        return res;

    }


    public void assignCol(TreeNode root, Map<TreeNode,Integer> col, Map<TreeNode,Integer> row){
        if(root == null)
        return;

        int parentCol = col.get(root);
        int parentRow = row.get(root);
        if(root.left != null){
             col.put(root.left, parentCol-1);
             row.put(root.left, parentRow+1);

        }
       
        if(root.right != null){
            col.put(root.right, parentCol+1);
            row.put(root.right, parentRow+1);
        }
        
        assignCol(root.left, col, row); 
        assignCol(root.right, col, row); 

    }
}