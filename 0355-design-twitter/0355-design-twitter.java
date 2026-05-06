class Twitter {
    int timer;
    HashMap<Integer, List<int[]>> userTweet;
    HashMap<Integer, HashSet<Integer>> userFollowed;

    Comparator<int[]> cmp = (a, b) -> {
        return Integer.compare(b[1], a[1]);
    };

    public Twitter() {
        timer = 1;
        userTweet = new HashMap<>();
        userFollowed = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweet.putIfAbsent(userId, new ArrayList<>());
        userTweet.get(userId).add(new int[] { tweetId, timer++ });
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);

        if (userTweet.get(userId) != null) {
            for (int[] itr : userTweet.get(userId)) {
                pq.add(itr);
            }
        }

        if (userFollowed.get(userId) != null) {
            for (int followed : userFollowed.get(userId)) {

                if (userTweet.get(followed) != null) {
                    for (int[] itr : userTweet.get(followed)) {
                        pq.add(itr);
                    }
                }
            }
        }

        List<Integer> recent = new ArrayList<>();

        int k = 0;

        while (!pq.isEmpty() && k++ < 10) {
            recent.add(pq.poll()[0]);
        }

        return recent;
    }

    public void follow(int followerId, int followeeId) {
        userFollowed.putIfAbsent(followerId, new HashSet<>());
        userFollowed.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowed.get(followerId) != null) {
            userFollowed.get(followerId).remove(followeeId);
        }
    }
}