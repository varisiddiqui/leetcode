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
    public int amountOfTime(TreeNode root, int start) {
        TreeNode tar = target(root, start);

        //finding the parent of every node
        HashMap<Integer, TreeNode> parent = new HashMap<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        parent.put(root.val, null);

        assignParent(root, parent, vis);

        return bfs(tar, vis, parent);

    }

     public void assignParent(TreeNode root, HashMap<Integer, TreeNode> parent, HashMap<Integer, Boolean> vis){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        vis.put(root.val, false);

        while(!q.isEmpty()){
            TreeNode top = q.remove();
            if(top.left != null){
                q.add(top.left);
                vis.put(top.left.val, false);
                parent.put(top.left.val, top);
            }
            if(top.right != null){
                q.add(top.right);
                vis.put(top.right.val, false);
                parent.put(top.right.val, top);
            }

        }
        
    }


    public TreeNode target(TreeNode root, int start){
        if(root == null) return null;

        if(root.val == start) return root;

        TreeNode left = target(root.left, start);
        TreeNode right = target(root.right, start);

        if(left == null && right != null) return right;
        if(left != null && right == null) return left;
        return null;

        
    }

    public int bfs(TreeNode target, HashMap<Integer, Boolean> vis, HashMap<Integer, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target.val, true);
        int k=0;

        while(!q.isEmpty()){
            int sz = q.size();
            k++;

            for(int i=0; i<sz; i++){
                TreeNode top = q.remove();
                
                if(parent.get(top.val) != null && !vis.get(parent.get(top.val).val)){
                    q.add(parent.get(top.val));
                    vis.put(parent.get(top.val).val, true);
                }
                if(top.left != null && !vis.get(top.left.val)){
                    q.add(top.left);
                    vis.put(top.left.val, true);
                }
                if(top.right != null && !vis.get(top.right.val)){
                    q.add(top.right);
                    vis.put(top.right.val, true);
                }
            }
        }

       
        return k-1;
    }
}