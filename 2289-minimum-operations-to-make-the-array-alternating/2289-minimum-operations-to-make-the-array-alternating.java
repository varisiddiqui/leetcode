class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> odd = new HashMap<>();
        HashMap<Integer, Integer> even = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i%2==0)
            odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            else
            even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<int[]> cmp = (a, b) -> {
            return b[1]-a[1];
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        //for Odd
        for(Integer key: odd.keySet()){
            pq.add(new int[]{key, odd.get(key)});
        }

        int o[][] = new int[2][2];
        int e[][] = new int[2][2];

        if(!pq.isEmpty()){
            o[0][0] = pq.peek()[0];
            o[0][1] = pq.peek()[1];
            pq.remove();
        }

        if(!pq.isEmpty()){
            o[1][0] = pq.peek()[0];
            o[1][1] = pq.peek()[1];
            pq.remove();
        }
    pq.clear();

    //for even
    for(Integer key: even.keySet()){
            pq.add(new int[]{key, even.get(key)});
        }


        if(!pq.isEmpty()){
            e[0][0] = pq.peek()[0];
            e[0][1] = pq.peek()[1];
            pq.remove();
        }

        if(!pq.isEmpty()){
            e[1][0] = pq.peek()[0];
            e[1][1] = pq.peek()[1];
            pq.remove();
        }

        if(o[0][0] != e[0][0]){
            return n-(o[0][1]+e[0][1]);
        }

        else{
            int ans1 = o[0][1]+e[1][1];
            int ans2 = o[1][1]+e[0][1];

            System.out.println(ans1+" "+ ans2);

            return n-(Math.max(ans1, ans2));
        }

       
    }
}
