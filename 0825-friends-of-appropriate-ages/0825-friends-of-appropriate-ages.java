class Solution {
    public int numFriendRequests(int[] ages) {
        // Step 1: Count the frequency of each age
        int[] ageCounts = new int[121];
        for (int age : ages) {
            ageCounts[age]++;
        }
        
        int totalRequests = 0;
        
        // Step 2: Compare every age against every other age
        for (int ageA = 15; ageA <= 120; ageA++) { // Start at 15 because < 15 will always fail the 0.5x + 7 rule
            if (ageCounts[ageA] == 0) continue;
            
            for (int ageB = 1; ageB <= 120; ageB++) {
                if (ageCounts[ageB] == 0) continue;
                
                // The three conditions where a request is NOT sent
                if (ageB <= (ageA / 2) + 7) continue;
                if (ageB > ageA) continue;
                
                // If conditions pass, all people of ageA send to all people of ageB
                totalRequests += ageCounts[ageA] * ageCounts[ageB];
                
                // If they are the same age, subtract the self-requests
                if (ageA == ageB) {
                    totalRequests -= ageCounts[ageA];
                }
            }
        }
        
        return totalRequests;
    }
}