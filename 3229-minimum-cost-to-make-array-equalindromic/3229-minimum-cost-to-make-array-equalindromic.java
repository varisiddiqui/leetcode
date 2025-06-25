class Solution {

    static ArrayList<Integer> palindrome = genPalin();

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //calculate prefix sum
        long prefixSum[] = new long[n];
        prefixSum[0]=nums[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        long sum = prefixSum[n-1]; //total

        ArrayList<Integer> a = palindrome;
       
        
        
       
        
        //System.out.println(a.get(leftIdx)+" "+a.get(rightIdx));


        
        //find pos with binsearch
        long min = Long.MAX_VALUE;
        for(int i=0; i<a.size();i++){
            
            //case 1: if key is leftmost
            int key = a.get(i);
            
            if(key<=nums[0]){
                long diff = sum - ((long)n*key);
               
                min = Math.min(min, diff);
            }
            //case 2: if key is rightmost
            else if(key>=nums[n-1]){
                long diff = ((long)n*key)-sum;
                min = Math.min(min, diff);
                
            }

            //case 3: if key in between given array
            else{
                int pos = Arrays.binarySearch(nums, key);
                
                if(pos<0){
                    pos = -pos-1;
                }
                long leftsum = prefixSum[pos-1];
                long leftSelf = (pos-1+1)*(long)key;
                long rightsum = sum - prefixSum[pos-1];
                long rightself = (n-pos)*(long)key;
                long total = (leftSelf- leftsum) + (rightsum-rightself);
               
                min = Math.min(min, total);
            }

        }
        return min;
    }

    public static ArrayList<Integer> genPalin(){
        Set<Integer> set = new TreeSet<>();
        for(int i=1; i<100000; i++){
            String s = Integer.toString(i);
            int len = s.length();
                String even = s + new StringBuilder(s).reverse().toString();

                String odd = s + new StringBuilder(s.substring(0, len-1)).reverse().toString();

                long num1 = Long.parseLong(even);
                long num2 = Long.parseLong(odd);

                if(num1 < 1_000_000_000)
                set.add((int)num1);
                if(num2 < 1_000_000_000)
                set.add((int)num2);
        }
        return new ArrayList<>(set);
    }
}