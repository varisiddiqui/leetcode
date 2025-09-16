class Solution {
    public String repeatLimitedString(String s, int r) {
        TreeMap<Character, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            tm.put(ch, tm.getOrDefault(ch, 0) + 1);
        }
        StringBuilder str = new StringBuilder("");

        while(!tm.isEmpty()) {
            char ch = tm.firstKey();
            int fr = tm.get(ch);
            tm.remove(ch);

            while (fr != 0) {
                int mini = Math.min(fr, r);
                for (int i = 0; i < mini; i++)
                    str.append(ch);
                fr -= mini;
                if (fr > 0) {
                    if (!tm.isEmpty()) {
                        char c2 = tm.firstKey();
                       
                        str.append(c2);
                        if (tm.get(c2) - 1 > 0)
                            tm.put(c2, tm.get(c2) - 1);
                        else
                         tm.remove(c2);

                    } else {
                        return str.toString();
                    }
                }
            }
        }

        return str.toString();

    }
}