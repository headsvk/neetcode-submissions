class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        val queue = ArrayDeque<Int>()
        var freshCount = 0

        // 1. Collect all initial rotten oranges (sources) and count fresh ones
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                when (grid[r][c]) {
                    2 -> queue.addLast(r * cols + c)
                    1 -> freshCount++
                }
            }
        }

        // Fast-path: no fresh oranges to begin with
        if (freshCount == 0) return 0

        val dr = intArrayOf(1, -1, 0, 0)
        val dc = intArrayOf(0, 0, 1, -1)
        var minutes = 0

        // 2. Process wave by wave
        while (queue.isNotEmpty() && freshCount > 0) {
            
            repeat(queue.size) {
                val key = queue.removeFirst()
                val r = key / cols
                val c = key % cols

                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]

                    // Guard: out of bounds or not a fresh orange
                    if (nr !in 0 until rows || nc !in 0 until cols || grid[nr][nc] != 1) {
                        continue
                    }

                    // Rot the orange immediately to prevent duplicate enqueues
                    grid[nr][nc] = 2
                    freshCount--
                    queue.addLast(nr * cols + nc)
                }
            }

            minutes++
        }

        return if (freshCount == 0) minutes else -1
    }
}
