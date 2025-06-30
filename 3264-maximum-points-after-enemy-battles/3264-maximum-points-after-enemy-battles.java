class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if(currentEnergy<enemyEnergies[0]) return 0;
        int n = enemyEnergies.length;
        int j=n-1;
        long count=0;
        long smallest = enemyEnergies[0];
        while(j>=0){

            if(smallest <= currentEnergy){
                long times = currentEnergy/smallest;
                count += times;
                currentEnergy -= (times*smallest);
            }
            else {
                currentEnergy += enemyEnergies[j];
                j--;
            }
        }
        return count;
    }
}