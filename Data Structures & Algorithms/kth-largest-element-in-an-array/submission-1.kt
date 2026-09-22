class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>(k)

        for (n in nums) {
            if (minHeap.size < k) {
                minHeap.add(n)
            } else if (n > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(n)
            }
        }

        return minHeap.peek()
    }
}
