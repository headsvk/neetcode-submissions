class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var (newStart, newEnd) = newInterval
        val result = mutableListOf<IntArray>()

        // Add intervals before new one
        var i = 0
        while (i < intervals.size) {
            val interval = intervals[i]
            
            if (interval[1] < newStart) {
                result.add(interval)
            } else {
                break
            }
            i++
        }

        // Merge intervals
        while (i < intervals.size) {
            val interval = intervals[i]
            if (newEnd >= interval[0]) {
                newStart = minOf(newStart, interval[0])
                newEnd = maxOf(newEnd, interval[1])
            } else {
                break
            }
            i++
        }
        result.add(intArrayOf(newStart, newEnd))

        // Add the rest
        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}
