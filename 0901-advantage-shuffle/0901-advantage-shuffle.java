class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int num1[][] = new int[n][2];
        int num2[][] = new int[n][2];

        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++){
            num1[i][0] = nums1[i];
            num1[i][1] = i;
            num2[i][0] = nums2[i];
            num2[i][1] = i;
        }

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(num1, cmp);
        Arrays.sort(num2, cmp);

        Stack<Integer> s = new Stack<>();
        
        int i=0;
        int j=0;
        while(i<n && j<n){
            if(num1[i][0] > num2[j][0]){
                ans[num2[j][1]] = num1[i][0];
                i++;
                j++;
            }
            else{
                s.add(num1[i][0]);
                i++;
            }
        }

        for(int k=0; k<n; k++){
            if(ans[k] == -1){
                ans[k] = s.pop();
            }
        }

        return ans;

        
        
    }
}