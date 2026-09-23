class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size

        fun dfs(r: Int, c: Int, index: Int): Boolean {
            // Base case: matched the entire word
            if (index == word.length) return true

            // Out of bounds or mismatch (including visited sentinel '#')
            if (r !in 0 until rows || c !in 0 until cols || board[r][c] != word[index]) {
                return false
            }

            // 1. Choose: mark visited
            board[r][c] = '#'

            // 2. Explore: 4 directions
            val found = dfs(r + 1, c, index + 1) ||
                        dfs(r - 1, c, index + 1) ||
                        dfs(r, c + 1, index + 1) ||
                        dfs(r, c - 1, index + 1)

            // 3. Un-choose: restore directly using the known character
            board[r][c] = word[index]

            return found
        }

        // Try starting the search from every cell that matches word[0]
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (board[r][c] == word[0] && dfs(r, c, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
