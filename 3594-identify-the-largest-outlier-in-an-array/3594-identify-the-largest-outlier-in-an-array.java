class Solution {
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        //take sum
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
       


        int max=-1000;
        
        for(int i=0; i<n; i++){
            
            if(hm.containsKey(sum-(2*nums[i])) ){
                int outlier = sum-(2*nums[i]);
            
                if(nums[i]==outlier){
                    int rem = sum-(nums[i]*hm.get(nums[i]));
                    //hm.put(nums[i], hm.get(nums[i])-2);
                    if((hm.get(nums[i])-2)>0){
                        rem += (nums[i]*(hm.get(nums[i])-2));
                    }
                    if(rem == (nums[i]))
                        max = Math.max(max, outlier);
                }
                else{
                    int rem = sum - ((nums[i]*hm.get(nums[i])) + (outlier*hm.get(outlier)));

                    if((hm.get(nums[i])-1)>0){
                        rem += ((hm.get(nums[i])-1)*nums[i]);
                    }
                    if((hm.get(outlier)-1)>0){
                        rem += ((hm.get(outlier)-1)*outlier);
                    }
                    if(rem == nums[i])
                    max = Math.max(max, outlier);


                }
                
               
                
            }
          
        }
        return max;
    }
}