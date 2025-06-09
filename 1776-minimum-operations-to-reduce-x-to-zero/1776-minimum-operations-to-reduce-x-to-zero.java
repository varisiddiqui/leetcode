class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm1= new HashMap<>();
        HashMap<Integer, Integer> hm2= new HashMap<>();
        int n = nums.length;
        int sum=0;
        int totSum=0;
        for(int i=0; i<n; i++){
            totSum += nums[i];
            sum += nums[i];
            hm1.put(sum, i+1);
        }
        sum=0;
        for(int i=n-1; i>=0; i--){
            sum += nums[i];
            hm2.put(sum, (n-i));
        }
        int minOp=n;
        for(Integer key: hm1.keySet()){
            if(x==key){
                minOp = Math.min(minOp, hm1.get(key));
            }
            else if(x-key>0 && hm2.containsKey(x-key)){
                minOp = Math.min(minOp, (hm1.get(key)+hm2.get(x-key)));
            }
        }

        for(Integer key: hm2.keySet()){
            if(x==key){
                minOp = Math.min(minOp, hm2.get(key));
            }
            else if(x-key>0 && hm1.containsKey(x-key)){
                minOp = Math.min(minOp, (hm2.get(key)+hm1.get(x-key)));
            }
        }
        if(minOp == n && totSum==x) return n;
        else if(minOp == n) return -1;
        return minOp;
    }
}