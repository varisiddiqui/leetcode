class Solution {
    static class Pair{
        char ch;
        int fr;
        public Pair(char ch, int f){
            this.ch = ch;
            this.fr = f;
        }
    }
    public String repeatLimitedString(String s, int r) {
        Map<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        StringBuilder str = new StringBuilder("");

        Comparator<Pair> cmp = (a, b) -> {
            return b.ch-a.ch;
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);

        for(Character key: hm.keySet()){
            pq.add(new Pair(key, hm.get(key)));
        }

        while(!pq.isEmpty()){
            char ch = pq.peek().ch;
            int fr = pq.peek().fr;
            pq.remove();

            while (fr != 0) {
                int mini = Math.min(fr, r);
                for (int i = 0; i < mini; i++)
                    str.append(ch);
                fr -= mini;
                if (fr > 0) {
                    if (!pq.isEmpty()) {
                        char c2 = pq.peek().ch;
                        int f2 = pq.peek().fr;
                        pq.remove();
                        str.append(c2);
                        if (f2 - 1 > 0)
                            pq.add(new Pair(c2, f2-1));

                    } else {
                        return str.toString();
                    }
                }
            }
        }

        return str.toString();

    }
}