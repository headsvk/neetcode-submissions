class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        var maxArea = 0

        fun dfs(r: Int, c: Int): Int {
            // Guard clause: return 0 on boundary violation or water/already visited
            if (r !in 0 until rows || c !in 0 until cols || grid[r][c] == 0) {
                return 0
            }

            // Sink the cell permanently in-place (no backtracking!)
            grid[r][c] = 0

            // 1 (current cell) + sum of all 4 cardinal directions
            return 1 + dfs(r + 1, c) +
                       dfs(r - 1, c) +
                       dfs(r, c + 1) +
                       dfs(r, c - 1)
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    maxArea = maxOf(maxArea, dfs(r, c))
                }
            }
        }

        return maxArea
    }
}
