class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int count=0;

        //count 1's
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1')
            count++;
        }

        if(count<k) 
        return "";

        if(k==1 && count>0)
        return "1";

        //create array to store index of 1
        int idx[] = new int[count];
        int j=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1')
            idx[j++] = i;
        }


        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i=0; i<idx.length-k+1; i++){
            String dup = s.substring(idx[i], idx[i+k-1]+1);
            //System.out.println(dup);
            if(pq.isEmpty()){
                pq.add(dup);
            }
            else if(pq.peek().length() > dup.length()){
                while(!pq.isEmpty() && pq.peek().length()>dup.length()){
                   System.out.println(pq.remove());
                }
                pq.add(dup);
            }
            else if(pq.peek().length() == dup.length()){
                pq.add(dup);
            }
        }

        return pq.peek();
    }
}