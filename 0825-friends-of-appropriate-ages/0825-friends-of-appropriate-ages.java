class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        int left = 0;
        int right = 0;
        
        for (int x = 0; x < ages.length; x++) {
            if (ages[x] < 15) continue; 
            int cond = (ages[x] / 2) + 7;

            // Move the left pointer to the first valid (youngest) person
            while (left < ages.length && ages[left] <= cond) {
                left++;
            }
            
            // Move the right pointer past the last valid person (handling duplicates)
            while (right < ages.length && ages[right] <= ages[x]) {
                right++;
            }
            
            // Add the valid window size. 
            // We subtract 1 to ensure a person doesn't send a request to themselves.
            count += Math.max(0, right - left - 1);
        }
        
        return count;
    }
}