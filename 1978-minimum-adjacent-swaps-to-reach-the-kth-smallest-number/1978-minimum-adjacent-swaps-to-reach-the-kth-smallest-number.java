class Solution {
    public int getMinSwaps(String s, int k) {
        int n = s.length();
        int nums[] = new int[s.length()];
        for(int i=0; i<n; i++){
            nums[i] = s.charAt(i) - '0';
        }
        for(int i=0; i<k; i++){
            nextPermutation(nums);
        }
        int count=0;

        for(int i=0; i<n; i++){
            int to = s.charAt(i) - '0';
            if(nums[i] == to) continue;
        
            for(int j=i+1; j<n; j++){
                if(nums[j] == to){
                    int r=j;
                    while(r>i){
                        swap(nums, r-1, r);
                        
                        r--;
                        count++;
                        
                    }
                    break;
                }
                
            }      
        }
        return count;
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such element found, find element just larger and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}