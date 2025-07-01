class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hm =  new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0) + 1);
        }
        int round=0;
        for(Integer key: hm.keySet()){
            int freq = hm.get(key);
            if(freq<2) return -1;

            if(freq%3==0){
                round += (freq/3);
            }
            else if((freq-2)%3 == 0){
                round += (freq-2)/3;
                round++;
            }
            else if((freq-4)%3 == 0){
                round += (freq-4)/3;
                round += 2;
            }
            
        }
        return round;
    }
}