class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty() || board[0].isEmpty()) return

        val rows = board.size
        val cols = board[0].size

        fun dfs(r: Int, c: Int) {
            // Guard: out of bounds or not an unvisited border-connected 'O'
            if (r !in 0 until rows || c !in 0 until cols || board[r][c] != 'O') {
                return
            }

            // Mark as safe/rescued
            board[r][c] = 'T'

            // Flood fill neighbors
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        // 1. Traverse border cells and mark all safe connected 'O' components
        for (r in 0 until rows) {
            if (board[r][0] == 'O') dfs(r, 0)
            if (board[r][cols - 1] == 'O') dfs(r, cols - 1)
        }
        for (c in 0 until cols) {
            if (board[0][c] == 'O') dfs(0, c)
            if (board[rows - 1][c] == 'O') dfs(rows - 1, c)
        }

        // 2. Final sweep: capture remaining 'O's, restore 'T's back to 'O'
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                when (board[r][c]) {
                    'O' -> board[r][c] = 'X' // Surrounded -> Captured
                    'T' -> board[r][c] = 'O' // Border-connected -> Restored
                }
            }
        }
    }
}
