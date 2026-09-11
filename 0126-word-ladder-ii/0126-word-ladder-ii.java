class Solution {

    
    String b;
    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    static class Pair{
        String node;
        int dist;

        public Pair(String node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public void dfs(String word, List<String> li){

        if(word.equals(b)){
            List<String> t = new ArrayList<>(li);
            Collections.reverse(t);
            ans.add(new ArrayList<>(t));
            return;
        }
        
        for(int i=0; i<word.length(); i++){
            StringBuilder str = new StringBuilder(word);
            for(char ch='a'; ch<='z'; ch++){
                str.setCharAt(i, ch);
                String s = str.toString();

                if(map.containsKey(s) && map.get(s) == map.get(word)-1){
                    li.add(s);
                    dfs(s, li);
                    li.remove(li.size()-1);
                }
            }
        }
    }


     

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        
        
        b = beginWord;
        
        //finding the  shortest dist from the beginWord

        

        Set<String> set = new HashSet<>();
        
        for(String s: wordList) set.add(s);

        set.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            

            String node = curr.node;
            int dist = curr.dist;

            map.putIfAbsent(node, dist);

            for(int i=0; i<node.length(); i++){
                StringBuilder str = new StringBuilder(node);

                for(char ch='a'; ch<='z'; ch++){
                    str.setCharAt(i, ch);
                    String s = str.toString();
                    if(set.contains(s)){
                        q.add(new Pair(s, dist+1));
                        set.remove(s);
                    }
                }
            }
        }

        List<String> li = new ArrayList<>();

        li.add(endWord);

        if(!map.containsKey(endWord)) return ans;

        dfs(endWord, li);

        

        return ans;
    }
}