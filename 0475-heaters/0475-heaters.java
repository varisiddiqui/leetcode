class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int house = houses.length;
        int heater = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        if(heater == 1) 
        return Math.max(Math.abs(heaters[0]-houses[0]), Math.abs(heaters[0]-houses[house-1]));
     

        long maxR=0;

        //for 2 or more heaters
        int l=0, r=1, i=0;
     
        while(i<house){
            if(houses[i]< heaters[l]){
                maxR = Math.max(maxR, heaters[l] - houses[i]);
                i++;
            }
            else if(heaters[l] <= houses[i] && houses[i] <= heaters[r]){
                int minD = Math.min(Math.abs(houses[i] - heaters[l]), Math.abs(heaters[r] - houses[i]));
                maxR = Math.max(maxR, minD);
                i++;
            }
            else{
                if(r+1 < heater){
                    l++;
                    r++;
                }
                else{
                    maxR = Math.max(maxR, Math.abs(houses[house-1] - heaters[r]));
                    break;
                    
                }
                
            }
            
        }

        return (int)maxR;

        
    }
}