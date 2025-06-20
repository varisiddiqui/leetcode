class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        if(hm.size()==1 && !hm.containsKey(0)) return 0;
        if(hm.size()==1 && hm.containsKey(0)){
            System.out.println(hm.get(0));
        }
        


        HashMap<Integer, Integer> freq = new HashMap<>();
        long sum=0;
        
        for(int i=0; i<nums.length; i++){
            
            
                int sh = nums[i]*2;
                
                
                if(hm.containsKey(sh) && freq.containsKey(sh)){
                    long total=hm.get(sh);
                    if(sh==0) total--;
                    long left = freq.get(sh);
                    long right = total - left;
                    
                    System.out.println(left+" "+right);
                    if(left>0 && right>0){
                        sum = sum + (left*right);
                    }
                }
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            
        }
        return (int)(sum%((long)Math.pow(10,9)+7));

        

        
        
    }
}