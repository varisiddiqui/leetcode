/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        //finding the parent of every node
        HashMap<Integer, TreeNode> parent = new HashMap<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        parent.put(root.val, null);
        

        assignParent(root, parent, vis);

        ans = bfs(target, vis, parent, k);
        return ans;
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

    public List<Integer> bfs(TreeNode target, HashMap<Integer, Boolean> vis, HashMap<Integer, TreeNode> parent, int k){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target.val, true);

        while(!q.isEmpty() && k>0){
            int sz = q.size();
            k--;

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

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
        return ans;
    }
}