class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        var count = 0

        fun dfs(r: Int, c: Int) {
            // Fast-fail boundary and state check
            if (r !in 0 until rows || c !in 0 until cols || grid[r][c] != '1') {
                return
            }

            // Sink the land in-place permanently (no backtrack!)
            grid[r][c] = '0'

            // Flood fill 4 cardinal neighbors
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    count++
                    dfs(r, c) // Completely sink this entire connected component
                }
            }
        }

        return count
    }
}
