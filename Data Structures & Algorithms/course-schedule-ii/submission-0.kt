class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val inDegree = IntArray(numCourses)
        // Adjacency list: prereq -> list of courses it unlocks
        val adj = Array(numCourses) { mutableListOf<Int>() }

        // 1. Build graph: prereq -> course
        for (edge in prerequisites) {
            val course = edge[0]
            val prereq = edge[1]
            adj[prereq].add(course)
            inDegree[course]++
        }

        // 2. Seed queue with courses that have 0 prerequisites (ready to take)
        val queue = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.addLast(i)
            }
        }

        // Pre-allocated primitive array for zero boxing
        val order = IntArray(numCourses)
        var index = 0

        // 3. Process BFS peel-off
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            order[index++] = curr

            for (nextCourse in adj[curr]) {
                inDegree[nextCourse]--
                if (inDegree[nextCourse] == 0) {
                    queue.addLast(nextCourse)
                }
            }
        }

        // If index != numCourses, a cycle prevented some courses from being taken
        return if (index == numCourses) order else intArrayOf()
    }
}
