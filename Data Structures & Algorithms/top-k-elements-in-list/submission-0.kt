class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val histogram = nums.asSequence().groupingBy { it }.eachCount()
        val minHeap = PriorityQueue<Map.Entry<Int, Int>>(compareBy { it.value })

        for ((index, entry) in histogram.entries.withIndex()) {
            if (index < k) {
                minHeap.offer(entry)
            } else {
                val (_, minFreq) = minHeap.peek()
                if (entry.value > minFreq) {
                    minHeap.poll()
                    minHeap.offer(entry)
                }
            }
        }

        return minHeap.stream()
            .mapToInt { it.key }
            .toArray()
    }
}
