class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        List<Integer> li = new ArrayList<>();
       
        int range[] = new int[2];

        Comparator<int[]> cmp = (a, b) -> {
            return a[0] - b[0];
        };

        PriorityQueue<int[]> min = new PriorityQueue<>(cmp);
        PriorityQueue<int[]> max = new PriorityQueue<>(cmp.reversed());
        int maxi=Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int num = nums.get(i).get(0);
            min.add(new int[] { num, 0, i });//number, eleIdx, listIdx
            maxi = Math.max(maxi, num);
        }

        


        int diff = Integer.MAX_VALUE;

        while (true) {
            int mini[] = min.peek();
            int minEl = mini[0];
            int minIdx = mini[1];
            int liIdx = mini[2];
        

            if (diff > (maxi - minEl)) {
                    diff = maxi - minEl;
                    range[0] = minEl;
                    range[1] = maxi;
                }

        

            if (minIdx + 1 < nums.get(liIdx).size()) {
                min.poll();
                min.add(new int[] { nums.get(liIdx).get(minIdx + 1), minIdx + 1, liIdx });
                
                maxi = Math.max(nums.get(liIdx).get(minIdx + 1), maxi);

            } else {
                break;
            }

        }
        return range;

    }
}