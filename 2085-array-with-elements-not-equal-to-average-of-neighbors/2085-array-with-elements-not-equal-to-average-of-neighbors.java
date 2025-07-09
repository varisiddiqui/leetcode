class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0, j=n-1, k=0;;
        int res[] = new int[n];
        while(i<j){
            res[k++]=nums[i];
            res[k++]=nums[j];
            i++;
            j--;
        }
        if(n%2!=0) res[k]=nums[i];
        return res;
    }
}