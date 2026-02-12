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

        //storing path nodes
        List<TreeNode> path = new ArrayList<>();
        findPath(root, target, path);

        int distTarget=k;

        while(path.size()>0){
            TreeNode child = path.remove(path.size()-1);

            if(path.isEmpty()) break;

            TreeNode parent = path.get(path.size()-1);

            distTarget--;
            if(distTarget == 0){
                ans.add(parent.val);
                break;
            }
            else{
                
                if(parent.left != child){
                    List<Integer> kNode = new ArrayList<>();
                    neigh(parent.left, distTarget-1, kNode);
                    ans.addAll(kNode);
                }
                if(parent.right != child){
                    List<Integer> kNode = new ArrayList<>();
                    neigh(parent.right, distTarget-1, kNode);
                    ans.addAll(kNode);
                }

            }
        }

        List<Integer> kNode = new ArrayList<>();
        neigh(target, k, kNode);

        ans.addAll(kNode);

        return ans;


    }

    public void neigh(TreeNode root, int rem, List<Integer> kNode){
        if(root == null) return;
        if(rem == 0) {
            kNode.add(root.val); 
            return;
        }

        if(root.left != null) neigh(root.left, rem-1, kNode);
        if(root.right != null) neigh(root.right, rem-1, kNode);
        
        return;

        
    }

    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root == null) return false;

        path.add(root);

        if(root.val == target.val) return true;

        if(findPath(root.left, target, path) || findPath(root.right, target, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;

        
    }
}