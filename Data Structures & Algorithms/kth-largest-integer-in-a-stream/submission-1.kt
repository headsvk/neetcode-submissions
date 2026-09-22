class KthLargest(private val k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()

    init {
        for (n in nums) {
            if (minHeap.size < k) {
                minHeap.add(n)
            } else if (n > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(n)
            }
        }
    }

    fun add(`val`: Int): Int {
        if (minHeap.size < k) {
            minHeap.add(`val`)
        } else if (`val` > minHeap.peek()) {
            minHeap.poll()
            minHeap.add(`val`)
        }
        return minHeap.peek()
    }
}
