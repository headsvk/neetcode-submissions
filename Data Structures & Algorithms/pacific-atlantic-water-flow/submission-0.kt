class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()

        val rows = heights.size
        val cols = heights[0].size
        val totalCells = rows * cols

        // 1D primitive tracking for zero-allocation visited state
        val pacific = BooleanArray(totalCells)
        val atlantic = BooleanArray(totalCells)

        val dr = intArrayOf(1, -1, 0, 0)
        val dc = intArrayOf(0, 0, 1, -1)

        fun dfs(r: Int, c: Int, visited: BooleanArray) {
            val key = r * cols + c
            visited[key] = true

            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                val nKey = nr * cols + nc

                // Guard: out of bounds, already visited, or cannot flow "uphill"
                if (nr !in 0 until rows || nc !in 0 until cols || visited[nKey]) {
                    continue
                }
                if (heights[nr][nc] < heights[r][c]) {
                    continue
                }

                dfs(nr, nc, visited)
            }
        }

        // 1. Traverse Pacific border (top row & left col)
        // and Atlantic border (bottom row & right col)
        for (r in 0 until rows) {
            dfs(r, 0, pacific)               // Left edge (Pacific)
            dfs(r, cols - 1, atlantic)       // Right edge (Atlantic)
        }
        for (c in 0 until cols) {
            dfs(0, c, pacific)               // Top edge (Pacific)
            dfs(rows - 1, c, atlantic)       // Bottom edge (Atlantic)
        }

        // 2. Find intersection
        val result = mutableListOf<List<Int>>()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                val key = r * cols + c
                if (pacific[key] && atlantic[key]) {
                    result.add(listOf(r, c))
                }
            }
        }

        return result
    }
}
