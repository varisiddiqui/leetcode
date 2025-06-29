class Solution {
    public int maxGoodNumber(int[] nums) {
        String bin[] = new String[3];
        for(int i=0; i<3; i++){
            bin[i]=Integer.toBinaryString(nums[i]);
        }
        int max=0;
        int arr[][] = { {0, 1, 2},
        {0, 2, 1},
        {1, 0, 2},
        {1, 2, 0},
        {2, 0, 1},
        {2, 1, 0}};

        for(int i=0; i<6; i++){
            int idx1 = arr[i][0];
            int idx2 = arr[i][1];
            int idx3 = arr[i][2];
            String concat = bin[idx1]+bin[idx2]
            +bin[idx3];
            int total = Integer.parseInt(concat, 2);
            max = Math.max(max, total);
        }
        

        return max;

    }
}