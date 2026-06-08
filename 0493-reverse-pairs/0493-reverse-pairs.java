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

        // 1. Divide and conquer
        count += mergeSortAndCount(nums, low, mid);
        count += mergeSortAndCount(nums, mid + 1, high);

        // 2. Count reverse pairs using the two-pointer approach
        count += countPairs(nums, low, mid, high);

        // 3. Merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int rightPtr = mid + 1;

        // Loop through each element in the sorted left half
        for (int leftPtr = low; leftPtr <= mid; leftPtr++) {
            // Advance rightPtr as long as the condition is satisfied
            // Using 1L * to prevent integer overflow
            while (rightPtr <= high && nums[leftPtr] > 2L * nums[rightPtr]) {
                rightPtr++;
            }
            // All elements from (mid + 1) up to (rightPtr - 1) are valid pairs
            count += (rightPtr - (mid + 1));
        }
        
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Standard merge process
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = nums[right++];
        }

        // Transfer elements back from temp to original array
        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}