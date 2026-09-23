class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder(2 * n)

        fun backtrack(openCount: Int, closeCount: Int) {
            // Base case: a valid string of length 2n is complete
            if (current.length == 2 * n) {
                result.add(current.toString())
                return
            }

            // Branch 1: Try adding '('
            if (openCount < n) {
                current.append('(')
                backtrack(openCount + 1, closeCount)
                current.setLength(current.length - 1) // backtrack
            }

            // Branch 2: Try adding ')'
            if (closeCount < openCount) {
                current.append(')')
                backtrack(openCount, closeCount + 1)
                current.setLength(current.length - 1) // backtrack
            }
        }

        backtrack(0, 0)
        return result
    }
}
