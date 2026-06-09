class Solution {
    public String orderlyQueue(String s, int k) {
        char ch[] = s.toCharArray();
        int n = ch.length;

        if(k > 1){
            Arrays.sort(ch);
            return new String(ch);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder str = new StringBuilder(s);
        for(int i=0; i<n; i++){
            pq.add(str.toString());
            str.append(str.charAt(0));
            str.deleteCharAt(0);
        }

        return pq.peek();

        
    }
}