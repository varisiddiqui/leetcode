class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        long sum=0;

        List<Integer> li = new ArrayList<>();
        int c=0;
        int z=0;
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                sum += nums[i];
                c++;
            }
            else if(nums[i] == 0){
                z++;
            }
            else{
                li.add(nums[i]);
            }
        }

        if(sum>0)
        c += z;

        
        Collections.sort(li, Collections.reverseOrder());
        //System.out.println(li+" "+sum);
        for(int i=0; i<li.size(); i++){
            sum += li.get(i);
            if(sum>0) c++;
            else break;
        }
        return c;
    
    }
}