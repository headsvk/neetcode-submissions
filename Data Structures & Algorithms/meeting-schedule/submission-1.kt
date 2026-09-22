/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sorted = intervals.sortedBy { it.start }

        var lastEnd = -1
        for (interval in sorted) {
            if (interval.start < lastEnd) {
                return false
            }
            lastEnd = interval.end
        }
        return true
    }
}
