class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        int n = arr.length;

        for(int num: arr) sum += num;
        

        if(sum%3 != 0) return false;

        int target = sum/3;
        int sum1=0;
        int c=0;

        for(int i=0; i<n; i++){
            sum1 += arr[i];
            if(sum1 == target && c<3){
                c++;
                sum1=0;
            }
        }
        if(sum1>0) return false;
        
        return c==3;

        
       

    }
}