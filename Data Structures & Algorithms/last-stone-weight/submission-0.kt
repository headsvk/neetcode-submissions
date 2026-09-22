class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(stones.map { it.inv() })
        
        while (maxHeap.size >= 2) {
            val y = maxHeap.poll().inv()
            val x = maxHeap.poll().inv()
            if (x < y) {
                maxHeap.add((y - x).inv())
            }
        }

        return maxHeap.firstOrNull()?.inv() ?: 0
    }
}
