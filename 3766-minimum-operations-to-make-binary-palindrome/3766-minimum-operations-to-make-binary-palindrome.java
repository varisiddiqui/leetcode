class Solution {
    static boolean isPal[] = new boolean[5000];
    static {
        for (int i = 1; i <= 5000; i++) {
            String bin = Integer.toBinaryString(i);
            String rev = new StringBuilder(bin).reverse().toString();
            isPal[i - 1] = (bin.equals(rev));
        }
    }

    public int[] minOperations(int[] nums) {

        int n = nums.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal[nums[i]-1])
                ans[i] = 0;
            else {
                int count1 = 1;
                boolean isP1=false;
                for (int j = nums[i] + 1; j <= 5000; j++) {
                    if (isPal[j-1]) {
                        isP1=true;
                        break;
                    } else
                        count1++;
                }

                int count2 = 1;
                boolean isP2=false;
                for (int j = nums[i] - 1; j >= 1; j--) {
                    if (isPal[j-1]) {
                        isP2 = true;
                        break;
                    } else
                        count2++;
                }
                if(isP1 && isP2) ans[i]=Math.min(count1, count2);
                else if(isP1) ans[i]=count1;
                else ans[i]=count2;
            }

        }
        return ans;

    }
}