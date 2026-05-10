class Solution {
    public int trap(int[] height) {
        int n = height.length;

        Comparator<int[]> cmp = (a, b) -> {
            return Integer.compare(b[0], a[0]); 
        };

        PriorityQueue<int[]> rightGreater = new PriorityQueue<>(cmp);
        PriorityQueue<Integer> leftGreater = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<n; i++){
            rightGreater.add(new int[]{height[i], i});
        }

        int water=0;

        int leftHt = 0;

        for(int i=0; i<n; i++){
             leftHt = Math.max(leftHt, height[i]);
            
            //right remove the all previous index

            while(!rightGreater.isEmpty() && rightGreater.peek()[1]<=i) rightGreater.poll();

            int rightHt = (rightGreater.isEmpty())? height[i]: Math.max(height[i], rightGreater.peek()[0]);

            int waterHt = Math.min(leftHt, rightHt);

            water += (waterHt - height[i]);
        }
        return water;
    }
}