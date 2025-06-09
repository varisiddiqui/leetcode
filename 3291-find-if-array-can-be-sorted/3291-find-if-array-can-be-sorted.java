class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int a[][] = new int[n][2];
        for(int i=0; i<n; i++){
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        for(int i=0; i<n; i++){
            int num = a[i][0];
            int pos = a[i][1];
            int bit = Integer.bitCount(num);
            if(i==pos)continue;
            else if(i>pos){
                while(pos++ < i){
                    int b2 = Integer.bitCount(nums[pos]);
                    if(b2 != bit) return false;
                }
            }
            else if(i<pos){
                while(pos-- > i){
                    int b2 = Integer.bitCount(nums[pos]);
                    if(b2 != bit) return false;
                }

            }
        }
        return true;
    }
}