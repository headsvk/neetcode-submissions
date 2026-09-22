class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(nums.map { it.inv() })

        for (i in 1 until k) {
            maxHeap.poll()
        }
        return maxHeap.poll().inv()
    }
}
