class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums)
        set.add(num);

        int maxCons=0;

        for(int num: set){
            if(!set.contains(num-1)){
                int count=1;
                int no=num+1;
                while(set.contains(no++)) count++;

                maxCons = Math.max(maxCons, count);
            }
        }
        return maxCons;
    }
}