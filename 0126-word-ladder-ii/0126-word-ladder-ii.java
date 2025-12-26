class Solution {

    // To store the final answers
    List<List<String>> ans = new ArrayList<>();

    // Map to store minimum steps (distance) from beginWord to each word
    Map<String, Integer> mpp = new HashMap<>();

    String b; // beginWord

    /*
     * DFS function to backtrack paths from endWord to beginWord
     */
    private void dfs(String word, List<String> seq) {

        // If we reached beginWord, reverse path and add to answer
        if (word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = mpp.get(word);
        int len = word.length();

        // Try changing each character
        for (int i = 0; i < len; i++) {
            char[] arr = word.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String replacedWord = new String(arr);

                // Check if previous step word exists
                if (mpp.containsKey(replacedWord)
                        && mpp.get(replacedWord) == steps - 1) {

                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1); // backtrack
                }
            }
        }
    }

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        // Store beginWord globally for DFS
        b = beginWord;

        // Set for fast lookup
        Set<String> st = new HashSet<>();
        for (String it : wordList) st.add(it);

        // Queue for BFS
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // Distance of beginWord is 1
        mpp.put(beginWord, 1);

        // Remove beginWord so it won't be reused
        st.remove(beginWord);

        int len = beginWord.length();

        // ---------------- BFS PART ----------------
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = mpp.get(word);

            // Stop BFS once endWord is found
            if (word.equals(endWord)) break;

            for (int i = 0; i < len; i++) {
                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String replacedWord = new String(arr);

                    if (st.contains(replacedWord)) {
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mpp.put(replacedWord, steps + 1);
                    }
                }
            }
        }

        // ---------------- DFS PART ----------------
        if (mpp.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}
