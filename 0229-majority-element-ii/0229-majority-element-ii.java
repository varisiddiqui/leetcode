class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int c1=0, c2=0, m1=0, m2=0;
        for(int i=0; i<n; i++){
            if(m1 == nums[i]) c1++;
            else if(m2 == nums[i]) c2++;
            else if(c1 == 0){
                c1 = 1;
                m1 = nums[i];
            }
            else if(c2 == 0){
                c2 = 1;
                m2 = nums[i];
            }
            else{
                c1--;
                c2--;
            }
        }
        List<Integer> al = new ArrayList<>();
        int c11=0, c22=0;
        for(int i=0; i<n; i++){
            if(m1 == nums[i]) c11++;
            else if(m2 == nums[i]) c22++;
        }
        if(c11>(n/3)) al.add(m1);
        if(c22>(n/3)) al.add(m2);
        return al;
    }
}