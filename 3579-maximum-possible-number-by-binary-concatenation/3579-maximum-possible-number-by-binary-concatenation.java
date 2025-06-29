class Solution {
    public int maxGoodNumber(int[] nums) {
        String bin[] = new String[3];
        for(int i=0; i<3; i++){
            bin[i]=Integer.toBinaryString(nums[i]);
        }
        int max=0;
        //first Combination
        String bin1 = bin[0]+bin[1]+bin[2];
        int tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);
        //2
        bin1 = bin[0]+bin[2]+bin[1];
        tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);
        
        bin1 = bin[2]+bin[0]+bin[1];
        tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);

        bin1 = bin[2]+bin[1]+bin[0];
        tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);

        bin1 = bin[1]+bin[2]+bin[0];
        tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);

        bin1 = bin[1]+bin[0]+bin[2];
        tot = Integer.parseInt(bin1, 2);
        max = Math.max(max, tot);

        return max;

    }
}