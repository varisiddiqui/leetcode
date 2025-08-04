class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;

        ArrayList<Integer> li = new ArrayList<>();
        li.add(nums[0]);

        for(int i=1; i<n; i++){
            if(nums[i] > li.get(li.size()-1)){
                li.add(nums[i]);
            }
            else{
                int idx = binSearch(li, nums[i]);
                li.set(idx, nums[i]);
            }
        }
        //System.out.println(li);
        return li.size();
        
    }

    public int binSearch(ArrayList<Integer> li, int key){
        int idx = Collections.binarySearch(li, key);
        if(idx<0){
            return -idx-1;
        }
        else{
            return idx;
        }
    }

    
}