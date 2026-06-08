

class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = 0;

        // 1. Divide phase
        count += mergeSortAndCount(nums, low, mid);
        count += mergeSortAndCount(nums, mid + 1, high);

        // 2. Count phase using YOUR exact logic
        count += countPairsYourWay(nums, low, mid, high);

        // 3. Merge phase
        merge(nums, low, mid, high);

        return count;
    }

    private int countPairsYourWay(int[] nums, int low, int mid, int high) {
        int count = 0;
        int leftPtr = low;

        // Iterate through each element in the right sorted array
        for (int rightPtr = mid + 1; rightPtr <= high; rightPtr++) {
            
            // Advance leftPtr until we find the FIRST element satisfying: nums[leftPtr] > 2 * nums[rightPtr]
            // We use 2L to cast to long and prevent integer overflow
            while (leftPtr <= mid && nums[leftPtr] <= 2L * nums[rightPtr]) {
                leftPtr++;
            }
            
            // If leftPtr hasn't run out of bounds, it means nums[leftPtr] (and every 
            // element after it up to 'mid') satisfies the condition for this specific rightPtr.
            if (leftPtr <= mid) {
                count += (mid - leftPtr + 1);
            }
        }
        
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}