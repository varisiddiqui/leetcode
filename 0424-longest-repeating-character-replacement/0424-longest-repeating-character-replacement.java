class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);
            hm.putIfAbsent(ch, new ArrayList<>());
            hm.get(ch).add(x);
        }

        int answer = 0;

        for (Character key : hm.keySet()) {
            List<Integer> li = hm.get(key);

            // handle single occurrence
            if (li.size() == 1) {
                answer = Math.max(answer, 1 + k);
                continue;
            }

            int i = 0, j = 1;
            int rem = k;

            // we track best total, not just internal
            int bestInternal = 1;
            int bestRem = k;
            int bestLeft = 0;
            int bestRight = 0;

            while (j < li.size()) {
                int gap = li.get(j) - li.get(j - 1) - 1;

                if (gap <= rem) {
                    int internalLen = li.get(j) - li.get(i) + 1;
                    int leftover = rem - gap;

                    // compute external capacity for THIS window
                    int leftCap = li.get(i);
                    int rightCap = s.length() - 1 - li.get(j);
                    int capacity = leftCap + rightCap;

                    int totalVal = internalLen + Math.min(leftover, capacity);

                    // ✔ FIX: choose window based on TOTAL VALUE
                    if (totalVal >
                        (bestInternal + Math.min(bestRem, bestLeft + bestRight))) {

                        bestInternal = internalLen;
                        bestRem = leftover;
                        bestLeft = leftCap;
                        bestRight = rightCap;
                    }

                    rem -= gap;
                    j++;
                } else {
                    rem += (li.get(i + 1) - li.get(i) - 1);
                    i++;
                }
            }

            // compute final max for this character
            int currentTotal = bestInternal + Math.min(bestRem, bestLeft + bestRight);

            answer = Math.max(answer, currentTotal);
        }

        return Math.min(answer, s.length());
    }
}
