class Solution {
    public String repeatLimitedString(String s, int r) {
        TreeMap<Character, Integer> tm = new TreeMap<>(Collections.reverseOrder());

        // count frequencies
        for (char ch : s.toCharArray()) {
            tm.put(ch, tm.getOrDefault(ch, 0) + 1);
        }

        StringBuilder str = new StringBuilder();

        while (!tm.isEmpty()) {
            Map.Entry<Character, Integer> e = tm.pollFirstEntry(); 
            char ch = e.getKey();
            int fr = e.getValue();

            while (fr > 0) {
                int mini = Math.min(fr, r);
                for (int i = 0; i < mini; i++) {
                    str.append(ch);
                }
                fr -= mini;

                if (fr > 0) {
                    if (!tm.isEmpty()) {
                        Map.Entry<Character, Integer> e2 = tm.pollFirstEntry();
                        char c2 = e2.getKey();
                        int f2 = e2.getValue();

                        str.append(c2);

                        if (f2 - 1 > 0) tm.put(c2, f2 - 1);
                        tm.put(ch, fr); // put remaining back
                        break; // continue outer loop
                    } else {
                        return str.toString();
                    }
                }
            }
        }

        return str.toString();
    }
}
