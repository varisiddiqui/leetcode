class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1=0;
        int sum2=0;

        int n1= nums1.length;
        int n2= nums2.length;

        for(int i=0; i<nums1.length; i++)
        sum1 += nums1[i];

        for(int i=0; i<nums2.length; i++)
        sum2 += nums2[i];

        if(n1>n2){
            if(n1*1 > n2*6) return -1;
        }
        if(n2>n1){
            if(n2*1 > n1*6) return -1;
        }

        if(sum1 == sum2) return 0;
        
        int diff[] = new int[n1+n2];
        int k=0;
        int gap = Math.abs(sum1-sum2);

        if(sum1 > sum2){
            for(int i=0; i<n1; i++)
            diff[k++] = nums1[i]-1;

            for(int i=0; i<n2; i++)
            diff[k++] = 6-nums2[i];

            Arrays.sort(diff);
            int operations=0;
            for(int i=diff.length-1; i>=0; i--){
                if(gap<=0)
                break;
                else{
                    gap -= diff[i];
                    operations++;
                }
            }
            return operations;
        }
        else{
            for(int i=0; i<n2; i++)
            diff[k++] = nums2[i]-1;

            for(int i=0; i<n1; i++)
            diff[k++] = 6-nums1[i];

            Arrays.sort(diff);
            int operations=0;
            for(int i=diff.length-1; i>=0; i--){
                if(gap<=0)
                break;
                else{
                    gap -= diff[i];
                    operations++;
                }
            }
            return operations;

        }
        

        

       
        




    }
}