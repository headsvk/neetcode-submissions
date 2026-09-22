/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val time = mutableListOf<Pair<Int, Int>>()

        // Add both start and end timestamps into the timeline
        for (interval in intervals) {
            time.add(Pair(interval.start, 1))   // +1 acquires a room
            time.add(Pair(interval.end, -1))    // -1 releases a room
        }

        // Sort by timestamp and then room requirements so that rooms are freed first
        time.sortWith(compareBy({ it.first }, { it.second }))

        // Traverse the timeline counting the current and maximum room count needed
        var res = 0
        var count = 0
        for (t in time) {
            count += t.second
            res = maxOf(res, count)
        }

        // Return maximum room count needed
        return res
    }
}
