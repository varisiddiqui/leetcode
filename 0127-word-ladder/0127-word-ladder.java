class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> vis = new HashMap<>();

        

        for(String str: wordList) {
            graph.put(str, new ArrayList<>());
            vis.put(str, false);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(isValid(wordList.get(i), wordList.get(j))){
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

       

        int level=0;

        Queue<String> q = new LinkedList<>();

        vis.put(beginWord, true);
        q.add(beginWord);

        while(!q.isEmpty()){
            int sz= q.size();
            level++;

            for(int i=0; i<sz; i++){
                String curr = q.remove();

                for(String neigh: graph.get(curr)){
                    if(neigh.equals(endWord)) return level+1;
                    if(!vis.get(neigh)){
                        q.add(neigh);
                        vis.put(neigh, true);
                    }
                }
            }
        }

        return 0;
        


    }

    public boolean isValid(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

       
        int lf=1;

        int i=0;

        int l = Math.min(n1, n2);

        while(i<l){
            if(s1.charAt(i) != s2.charAt(i) && lf == 0) break;
            else if(s1.charAt(i) != s2.charAt(i) && lf==1) lf=0;

            i++;
        }
       

        return i==n1;
    }
}