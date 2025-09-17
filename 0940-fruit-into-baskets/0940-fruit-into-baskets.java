class Solution {
    public int totalFruit(int[] fruits) {
        int n =fruits.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i=0; 
        int j=0;
        int max=0;
        
        while(i<n && j<n){
            while(hm.size()<=2 && j<n){
                hm.put(fruits[j], hm.getOrDefault(fruits[j], 0) + 1);
                j++;
            }
            if(j==n && hm.size()<=2){
                max = Math.max(max, j-i);
            }
            else
            max = Math.max(max, j-i-1);
            //System.out.println(hm+" "+max+" "+i+" "+j);
            //System.out.println(hm+" ");
            while(hm.size()>2 && i<n){
                
                int fr = hm.get(fruits[i]);
                if(fr-1 > 0){
                    hm.put(fruits[i], fr-1);
                }
                else
                hm.remove(fruits[i]);
                //if(hm.size()<=2) break;
                i++;
            }
            System.out.println(hm+" ");
            //System.out.println(hm+" "+max+" "+i+" "+j);
            if(j==n && hm.size()<=2)
            max = Math.max(max, j-i);
            else
            max = Math.max(max, j-i-1);
        }

        return max;
    }
}