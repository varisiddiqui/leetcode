class Solution {
    public int longestOnes(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] == 0) li.add(i);
        }
        if(k >= li.size()) return n;

        int max=li.get(k)-1+1;

        int j=0;
        for(int i=k+1; i<li.size(); i++){
            max = Math.max(li.get(i) - li.get(j)-1, max);
            j++;
        }

        max = Math.max(max, n - li.get(li.size()-k-1)-1);
        return max;
    }
}