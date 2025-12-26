class Solution {

     static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
          Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(startWord, 1));

        Set<String> set = new HashSet<>(wordList);
        set.remove(startWord);

        while (!q.isEmpty()) {

            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;

            if (word.equals(targetWord)) return steps;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String next = new String(arr);

                    if (set.contains(next)) {
                        set.remove(next);
                        q.add(new Pair(next, steps + 1));
                    }
                }
                arr[i] = original; // restore
            }
        }
        return 0;
    }
}