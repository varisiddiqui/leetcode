class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int nhouse = houses.length;
        int nheater = heaters.length;
        int maxSingle=Integer.MIN_VALUE;
        if(nheater==1){
            for(int i=0; i<nhouse; i++)
                maxSingle = Math.max(maxSingle, Math.abs(heaters[0]-houses[i]));
                return maxSingle;
        }


        int max = Integer.MIN_VALUE;
       
            int i=0;
            int l=0,r=1;
            while(i<nhouse){
                if(houses[i]<=heaters[l]){
                    max = Math.max(max, Math.abs(houses[i]-heaters[l]));
                    i++;
                }
                else if(houses[i]>heaters[l] && houses[i]<=heaters[r]){
                    int near = Math.min(Math.abs(houses[i]-heaters[l]), Math.abs(houses[i]-heaters[r]));
                    max = Math.max(max, near);
                    i++;
                }
                else if(houses[i]>heaters[r]){
                    if(r+1<nheater){
                        l++;
                        r++;
                    }
                    else{
                        max = Math.max(max, houses[i]-heaters[nheater-1]);
                        i++;
                    }
                }
            
        }
        return max;
    }
}