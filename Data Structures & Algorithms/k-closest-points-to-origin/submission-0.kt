class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<Pair<Double, IntArray>>(compareByDescending { it.first })

        for (point in points) {
            val (x, y) = point
            val distance = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))

            if (maxHeap.size < k) {
                maxHeap.add(distance to point)
            } else if (distance < maxHeap.peek().first) {
                maxHeap.poll()
                maxHeap.add(distance to point)
            }
        }

        val result = arrayOfNulls<IntArray>(maxHeap.size)
        var index = 0
        for (pair in maxHeap) {
            result[index++] = pair.second
        }
        return result as Array<IntArray>
    }
}
