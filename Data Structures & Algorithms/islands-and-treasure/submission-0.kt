class Solution {
    private val INF = Int.MAX_VALUE

    fun islandsAndTreasure(grid: Array<IntArray>) {
        if (grid.isEmpty() || grid[0].isEmpty()) return

        val rows = grid.size
        val cols = grid[0].size
        val queue = ArrayDeque<Int>()

        // 1. Seed the queue with all gates (Multi-Source initialization)
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 0) {
                    queue.addLast(r * cols + c)
                }
            }
        }

        val dr = intArrayOf(1, -1, 0, 0)
        val dc = intArrayOf(0, 0, 1, -1)

        // 2. Uniform simultaneous expansion
        while (queue.isNotEmpty()) {
            val key = queue.removeFirst()
            val r = key / cols
            val c = key % cols
            val currentDist = grid[r][c]

            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]

                // Guard: boundary violation or not an unvisited empty room
                if (nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != INF) {
                    continue
                }

                // First arrival is guaranteed shortest distance
                grid[nr][nc] = currentDist + 1
                queue.addLast(nr * cols + nc)
            }
        }
    }
}
