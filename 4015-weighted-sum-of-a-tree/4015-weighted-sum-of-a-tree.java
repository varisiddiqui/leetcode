class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        if(n==1) return nums[0];

        HashMap<Integer, List<Integer>> parentOf = new HashMap<>();

        for(int i=1; i<n; i++){
            int par = parent[i];
            parentOf.putIfAbsent(par, new ArrayList<>());
            parentOf.get(par).add(i);
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 1}); //node, height
        int depth[] = new int[n];

        int h=1;
    

        while(!q.isEmpty()){
            int top[] = q.remove();
            depth[top[0]] = top[1];
            h = Math.max(h, top[1]);

            List<Integer> child = parentOf.getOrDefault(top[0], new ArrayList<>());
        
                for(int ch: child){
                    q.add(new int[]{ch, top[1]+1});
                }
            

        }

        long sum=0;

        for(int i=0; i<n; i++){
            sum += (long)nums[i] * 1L*(h-depth[i]+1);
        }
        return sum;
        
    }
}