class Solution {
    companion object {
        private const val EMPTY = 0
        private const val FRESH = 1
        private const val ROTTEN = 2
    }

    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        val queue = ArrayDeque<Int>()
        var freshCount = 0

        // 1. Initial scan
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                when (grid[r][c]) {
                    ROTTEN -> queue.addLast(r * cols + c)
                    FRESH  -> freshCount++
                }
            }
        }

        if (freshCount == 0) return 0

        val dr = intArrayOf(1, -1, 0, 0)
        val dc = intArrayOf(0, 0, 1, -1)
        var minutes = 0

        // 2. Wave-by-wave spread
        while (queue.isNotEmpty() && freshCount > 0) {
            repeat(queue.size) {
                val key = queue.removeFirst()
                val r = key / cols
                val c = key % cols

                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]

                    // Guard: bounds or not fresh (handles EMPTY and already ROTTEN)
                    if (nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != FRESH) {
                        continue
                    }

                    grid[nr][nc] = ROTTEN
                    freshCount--
                    queue.addLast(nr * cols + nc)
                }
            }
            minutes++
        }

        return if (freshCount == 0) minutes else -1
    }
}
