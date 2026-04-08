class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < n - 2; i++) {
            sum1 += arr[i];
            sum2=0;
            for (int j = i + 1; j < n - 1; j++) {
                sum2 += arr[j];
                
                if (sum2 == sum1) {
                    sum3=0;
                    for (int k = j + 1; k < n; k++) {
                        sum3 += arr[k];
                    }
                    if(sum3 == sum2) return true;
                }

            }
            
        }
        return false;
    }
}