class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Comparator<int[]> cmp = (x, y) -> {
            return Integer.compare(y[1], x[1]);
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
        if(a>0)
        pq.add(new int[]{0, a});
        if(b>0)
        pq.add(new int[]{1, b});
        if(c>0)
        pq.add(new int[]{2, c});

        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()){
            char ch = (char)('a'+pq.peek()[0]);
            int freq = pq.peek()[1];
            pq.poll();

            if(str.length()>=2 && str.charAt(str.length()-1) == ch && str.charAt(str.length()-2) == ch){
                if(pq.isEmpty()) break;
                    char ch2 = (char)('a'+pq.peek()[0]);
                    int freq2 = pq.peek()[1];
                    pq.poll();

                    str.append(ch2);
                    freq2--;
                    if(freq2 > 0) pq.add(new int[]{ch2-'a', freq2});

                    pq.add(new int[]{ch-'a', freq});
            }
            else{
                str.append(ch);
                freq--;
                
                if(freq > 0) pq.add(new int[]{ch-'a', freq});
            }
        }
            
        

        

        return str.toString();
    }
}