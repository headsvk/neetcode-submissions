class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        // Sort the intervals by their start time
        intervals.sortBy { it[0] }

        var prevEnd = Int.MIN_VALUE
        var res = 0

        for ((start, end) in intervals) {
            if (start >= prevEnd) {
                // No overlap
                prevEnd = end
            } else {
                // Remove the interval that ends later
                prevEnd = minOf(end, prevEnd)
                res++
            }
        }

        return res
    }
}
