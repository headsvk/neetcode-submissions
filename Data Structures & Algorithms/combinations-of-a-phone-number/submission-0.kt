class Solution {
    private val keyMap = arrayOf(
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        val current = StringBuilder(digits.length)

        fun backtrack(index: Int) {
            // Base case: exactly one letter picked per digit
            if (index == digits.length) {
                result.add(current.toString())
                return
            }

            val letters = keyMap[digits[index] - '0']
            for (i in letters.indices) {
                current.append(letters[i])
                backtrack(index + 1)
                current.setLength(current.length - 1) // backtrack
            }
        }

        backtrack(0)
        return result
    }
}
