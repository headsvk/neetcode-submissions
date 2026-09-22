class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        intervals.sortWith(compareBy({ it[0]}, { it[1] }))

        result.add(intervals.first())
        for (i in 1 until intervals.size) {
            val interval = intervals[i]
            val top = result.last()

            if (interval[0] <= top[1]) {
                top[1] = maxOf(interval[1], top[1])
            } else {
                result.add(interval)
            }
        }

        return result.toTypedArray()
    }
}
