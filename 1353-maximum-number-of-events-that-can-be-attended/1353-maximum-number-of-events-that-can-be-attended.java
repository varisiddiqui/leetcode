class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]); 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int i = 0;
        int day = 0;
        int count = 0;

        while (i < n || !pq.isEmpty()) {

            // If no available event, jump to the next event's start day
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            // add all events that start on this day
            while (i < n && events[i][0] == day) {
                pq.add(events[i]);
                i++;
            }

            // attend event with earliest ending day
            int[] ev = pq.poll();
            if (day <= ev[1]) {
                count++;
                day++;
            }

            // remove expired events
            while (!pq.isEmpty() && pq.peek()[1] < day) {
                pq.poll();
            }
        }

        return count;
    }
}
