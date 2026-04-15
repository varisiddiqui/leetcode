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

        while(pq.size()>=2){
            int top1[] = pq.remove();
            int top2[] = pq.remove();

            int freq1 = top1[1];
            int freq2 = top2[1];

            char ch1 = (char)('a'+top1[0]);
            char ch2 = (char)('a'+top2[0]);


            if(freq1 == freq2){
                System.out.println(freq1+" "+freq2);
                int min1 = Math.min(freq1, 2);
                int min2 = Math.min(freq2, 2);
                for(int i=0; i<min1; i++) str.append(ch1);
                for(int i=0; i<min2; i++) str.append(ch2);

               

                if(freq1-min1>0) pq.add(new int[]{top1[0], freq1-min1});
                if(freq2-min2 >0) pq.add(new int[]{top2[0], freq2-min2});
            }

            else if(freq1 > freq2){
                for(int i=0; i<2; i++){
                    str.append(ch1);
                }
                if(freq1-2 > 0)
                    pq.add(new int[]{top1[0], freq1-2});

                str.append(ch2);
                if(freq2-1 > 0)
                pq.add(new int[]{top2[0], freq2-1});
            }
            else {
                for(int i=0; i<2; i++){
                    str.append(ch2);
                }
                if(freq2-2 > 0)
                    pq.add(new int[]{top2[0], freq2-2});

                str.append(ch1);
                if(freq1-1 > 0)
                pq.add(new int[]{top1[0], freq1-1});
            }
        }

        if(pq.size() == 1){
            char ch = (char)('a'+pq.peek()[0]);
            int min = Math.min(pq.peek()[1], 2);

            for(int i=0; i<min; i++){
                str.append(ch);
            }
        }
        

        

        return str.toString();
    }
}