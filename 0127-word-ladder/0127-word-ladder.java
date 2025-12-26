class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //directed bfs with unit weight
        HashMap<String, List<String>> hm = new HashMap<>();
    
        if(!wordList.contains(beginWord)) wordList.add(0, beginWord);
        int n = wordList.size();

        for(String key: wordList){
            hm.put(key, new ArrayList<>());
        }

        //edge case
        boolean isPresent = false;
        for(int i=0; i<n; i++){
            if(endWord.equals(wordList.get(i))){
                isPresent = true;
                break;
            }
        }

        if(!isPresent) return 0;

        

        int len = beginWord.length();

        for(int i=0; i<n; i++){
            String curr = wordList.get(i);


            //here positional diff is there
            
            for(int j=i+1; j<n; j++){
                int diff=0;
                String next = wordList.get(j);

                for(int k=0; k<len; k++){
                    if(curr.charAt(k) != next.charAt(k)) diff++;
                }

                if(diff == 1){
                    hm.get(curr).add(next); 
                    hm.get(next).add(curr);
                }               
            }


            //System.out.println(curr+" "+hm.get(curr));
        }

        HashMap<String, Integer> dist = new HashMap<>();
        for(String word: wordList){
            dist.put(word, Integer.MAX_VALUE);
        }
        dist.put(beginWord, 1);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            String top = q.remove();
            
            for(String neigh: hm.get(top)){
                if(dist.get(neigh) == Integer.MAX_VALUE){
                    dist.put(neigh, dist.get(top)+1);
                    q.add(neigh);
                    if(neigh.equals(endWord)) return dist.get(neigh);
                }
            }
        } 

        
        return 0;




    }
}