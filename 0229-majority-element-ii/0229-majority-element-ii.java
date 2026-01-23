class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1=0;
        int num1=-1;

        int c2=0;
        int num2=-1;

        for(int i=0; i<n; i++){
            if(c1 == 0 && nums[i] != num2){
                c1++;
                num1 = nums[i];
            }
            else if(c2 == 0 && nums[i] != num1){
                c2++;
                num2 = nums[i];
            }
            else if(nums[i] == num1) c1++;
            else if(nums[i] == num2) c2++;
            else {
                c1--;
                c2--;
            }
        }
        int limit = (int)Math.floor(n/3);
        int count1=0;
        int count2=0;
        for(int num: nums){
            if(num == num1) count1++;
            if(num == num2) count2++;
        }
        if(count1 == n) return new ArrayList<>(Arrays.asList(num1));
        if(count2 == n) return new ArrayList<>(Arrays.asList(num2));
        
        if(count1>limit && count2>limit){
            return new ArrayList<>(Arrays.asList(num1, num2));
        }
        else if(count1>limit) return new ArrayList<>(Arrays.asList(num1));
        else if(count2>limit) return new ArrayList<>(Arrays.asList(num2));
        return new ArrayList<>();
        

    }
}