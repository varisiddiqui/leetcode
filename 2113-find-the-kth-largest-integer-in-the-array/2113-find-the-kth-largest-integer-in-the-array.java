class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;

        Comparator<String> cmp = (a, b) -> {
            if(a.length() != b.length())
            return b.length()-a.length();
            else
            return b.compareTo(a);
        };
        Arrays.sort(nums, cmp);
        return nums[k-1];
     
    }
}