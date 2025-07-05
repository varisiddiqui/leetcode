class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

        int count=1;
        for(int i=0; i<n; i++){
            count=1;
            char ch = s.charAt(i);
            for(int j=i+1; j<n; j++){
                if(ch == s.charAt(j))
                count++;
                else {
                    break;
                }
            }
            hm.putIfAbsent(ch, new ArrayList<>());
            hm.get(ch).add(count);
        }
       
        int max = Integer.MIN_VALUE;
        for(Character key: hm.keySet()){
            ArrayList<Integer> val = hm.get(key);
            Collections.sort(val, Collections.reverseOrder());
            if(val.size()>2){
                max = Math.max(max, val.get(2));
            }
        }
       // System.out.println(hm);
        if(max==Integer.MIN_VALUE) return -1;
        return max;

    }
}