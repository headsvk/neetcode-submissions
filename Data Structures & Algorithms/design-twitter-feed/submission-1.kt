class Twitter {
    private var time = 0
    private val feedCount = 10

    private val followers = hashMapOf<Int, MutableSet<Int>>()
    private val tweets = hashMapOf<Int, MutableList<Pair<Int, Int>>>()

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.getOrPut(userId) { mutableListOf() }
            .add(time++ to tweetId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val minHeap = PriorityQueue<Pair<Int, Int>>(feedCount, compareBy { it.first })

        populateFeed(userId, minHeap)

        val follows = followers[userId].orEmpty()
        for (id in follows) {
            populateFeed(id, minHeap)
        }

        val result = ArrayDeque<Int>(minHeap.size)
        while (minHeap.isNotEmpty()) {
            result.addFirst(minHeap.poll().second)
        }
        return result.toList()
    }

    private fun populateFeed(userId: Int, minHeap: PriorityQueue<Pair<Int, Int>>) {
        val tweetIds = tweets[userId].orEmpty()

        for (i in tweetIds.indices.reversed()) {
            val tweet = tweetIds[i]

            if (minHeap.size < feedCount) {
                minHeap.add(tweet)
            } else if (minHeap.peek().first < tweet.first) {
                minHeap.poll()
                minHeap.add(tweet)
            } else {
                return
            }
        }
    }

    fun follow(followerId: Int, followeeId: Int) {
        followers.getOrPut(followerId) { hashSetOf() }
            .add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followerId]?.remove(followeeId)
    }
}
