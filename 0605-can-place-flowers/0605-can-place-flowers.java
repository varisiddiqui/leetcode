class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if(n==0) return true;
        if(nums.length == 1 && nums[0] == 0) return true;
        if(nums.length == 1 && nums[0] == 1) return false;
        int sz=nums.length;
       /* boolean can[] = new int[sz];
        Arrays.fill(can, true);

        for(int i=0; i<sz; i++){
            if(nums[i] == 1){
                can[i]=false;
                if(i-1>=0) can[i-1] = false;
                if(i+1<sz) can[i+1] = false;
            }
        }
        int insert=0;
        for(int i=0; i<sz; i++){
            if(nums[i] == 0){
                if(i-1>=0 && nums[i-1]==0 && can[i-1]==false) 
            }
        }


        int c=0;
        int insert=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0 && nums[i+1]==0){
                nums[i+1]=1;
                insert++;
            }
            if(insert>0 && nums[i]==1 && nums[i-1] == 1){
                i

            }
        }
        System.out.print(insert);

        return insert>=n?true : false;*/

        int c=0;
        for(int i=0; i<sz; i++){
            if(nums[i]==0){
                boolean isSafe1=true;
                boolean isSafe2=true;
                if(i-1>=0 && nums[i-1]==1){
                    isSafe1 = false;
                }
                if(i+1<sz && nums[i+1]==1){
                    isSafe2 = false;
                }
                if (isSafe1 && isSafe2){
                    nums[i]=1;
                    c++;
                }
            }
        }

        return (c>=n)?true:false;


    }
}