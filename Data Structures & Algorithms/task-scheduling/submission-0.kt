class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val frequencies = IntArray(26)
        for (task in tasks) {
            frequencies[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
        for (freq in frequencies) {
            if (freq > 0) {
                maxHeap.add(freq)
            }
        }

        var time = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            time++
            
            if (maxHeap.isEmpty()) {
                // Fast forward time if there are no more items in the heap
                time = queue.first().second
            } else {
                val count = maxHeap.poll() - 1
                // Schedule highest freq task
                if (count > 0) {
                    // Add to queue with time of next possible start
                    queue.addLast(count to time + n)
                }
            }

            // Remove item from queue if its possible to start it at this time
            if (queue.isNotEmpty() && queue.first().second == time) {
                maxHeap.add(queue.removeFirst().first)
            }
        }

        return time
    }
}
