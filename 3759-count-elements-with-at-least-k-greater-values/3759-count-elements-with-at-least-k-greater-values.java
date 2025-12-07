class Solution {
    public int countElements(int[] nums, int k) {
        if(k==0) return nums.length;
        TreeMap<Integer, Integer> hm = new TreeMap<>(Collections.reverseOrder());

        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        long sum=0;
        long totSum=0;
        int curr=0;
        for(int key: hm.keySet()){
            if(sum<k){
                sum += hm.get(key);
            }
            totSum += hm.get(key);
            
            
            
        }
       // System.out.println(hm);
        return (int)(totSum-sum);

    }
}