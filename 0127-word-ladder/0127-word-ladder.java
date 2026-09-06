class Solution {
    static class Pair{
        String node;
        int dist;

        public Pair(String node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            if(curr.node.equals(endWord)) return curr.dist;

            

            for(int i=0; i<curr.node.length(); i++){
                StringBuilder str = new StringBuilder(curr.node);
                for(char c = 'a'; c<='z'; c++){
                    str.setCharAt(i, c);
                    String t = str.toString();
                    if(set.contains(t)){
                        q.add(new Pair(t, curr.dist+1));
                        set.remove(t);
                    }

                }
            }
        }
        return 0;


    }
}