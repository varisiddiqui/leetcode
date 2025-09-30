class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int arr[][] = new int[n][2];


        for(int i=0; i<n; i++){
            arr[i][0] = nums1[i];//nums1
            arr[i][1] = i;//idx
        }

        Comparator<int[]> cmp = (a, b) -> {
            return a[0]-b[0];
        };

        Arrays.sort(arr, cmp);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans[] = new long[n];
        long sum1=0;
        long sum2=0;

        for(int i=0; i<n; i++){
            int num1 = arr[i][0];
            int idx = arr[i][1];
            int num2 = nums2[idx];
            
           
            if(i == 0){
                pq.add(num2);
                ans[idx] = 0;
                //System.out.println(0);
                sum2 += num2;
            }

            else{
                //case-1
                if(arr[i-1][0] == arr[i][0]){
                    if(pq.size()<k){
                        pq.add(num2);
                        sum2 += num2;
                    }
                    else{
                        if(pq.peek() < num2){
                            sum2 -= pq.peek();
                            sum2 += num2;
                            pq.remove();
                            pq.add(num2);
                        }
                    }
                    ans[idx] = sum1;
                    
                }
                //case-2
                else{
                    sum1 = sum2;
                     if(pq.size()<k){
                        pq.add(num2);
                        sum2 += num2;
                    }
                    else{
                        if(pq.peek() < num2){
                            sum2 -= pq.peek();
                            sum2 += num2;
                            pq.remove();
                            pq.add(num2);
                        }
                    }
                    ans[idx] = sum1;
                }               
            }
            
            
        }
        //System.out.println(hm);
      

        return ans;
    }
}