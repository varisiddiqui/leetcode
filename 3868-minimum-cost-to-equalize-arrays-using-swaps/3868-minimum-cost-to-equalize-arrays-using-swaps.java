class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        int n = nums1.length;

        for(int i=0; i<n; i++){
            hm1.put(nums1[i], hm1.getOrDefault(nums1[i], 0) + 1);
            hm2.put(nums2[i], hm2.getOrDefault(nums2[i], 0) + 1);
        }

        int cost1=0;
        int send1=0;
        int receive1=0;
        for(int key: hm1.keySet()){
            int f1 = hm1.get(key);
            int f2 = hm2.getOrDefault(key, 0);

            //case-1
            if(f1 == f2){
                continue;
            }

            //case-2
            else {
                int equal = (f1+f2)/2;

                if((f1+f2)%2 != 0) return -1;
                else {
                    if(f1 > equal) send1 += (f1-equal);
                    else receive1 += (equal - f1); 
                }
            }
           
        }
        cost1 = Math.min(send1, receive1) + Math.abs(send1-receive1);

        int cost2=0;
        int send=0;
        int receive=0;
        for(int key: hm2.keySet()){
            int f2 = hm2.get(key);
            int f1 = hm1.getOrDefault(key, 0);



            //case-1
            if(f1 == f2){
                continue;
            }

            //case-2
            else {
                int equal = (f1+f2)/2;

                if((f1+f2)%2 != 0) return -1;
                else{
                    if(f2 > equal) send += f2-equal;
                    else receive += equal-f2;
                }
            }
           
        }
        cost2 = Math.min(send, receive)+Math.abs(send-receive);
        
       
        return Math.min(cost1, cost2);
        
    }
}