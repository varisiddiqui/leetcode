/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        if(root == null) return "";

        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
           
            for(int i=0; i<sz; i++){
                 TreeNode top = q.remove();
                 if(top == null){
                    str.append("null ");
                    continue;
                 }
                 else{
                    str.append(String.valueOf(top.val)+" ");
                 }


                 if(top.left != null) q.add(top.left);
                 else q.add(null);

                 if(top.right != null) q.add(top.right);
                 else q.add(null);

            }
            
        }

        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       System.out.println(data);

       if (data == null || data.trim().length() == 0) return null;

        String str[] = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        int n = str.length;

        TreeNode root = null;
        for(int i=0; i<n; i++) str[i] =str[i].trim();

         
         if(n==0 || str[0].equals("") || str[0].equals("null")) return null;
         else{
            int n2 = Integer.parseInt(str[0].trim());
            root = new TreeNode(n2);
            q.add(root);
         }
         for(int i=1; i<n; i=i+2){
            TreeNode curr = q.remove();

            if(str[i].equals("null")){
                curr.left = null;
            }
            else{
                int n1 = Integer.parseInt(str[i].trim());
                TreeNode leftChild = new TreeNode(n1);
                curr.left = leftChild;
                q.add(leftChild);
            }

            if(i+1<n && str[i+1].equals("null")){
                curr.right = null;
            }
            else if(i+1<n){
                int n1 = Integer.parseInt(str[i+1].trim());
                TreeNode rightChild = new TreeNode(n1);
                curr.right = rightChild;
                q.add(rightChild);
            }
            
         }
         return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));