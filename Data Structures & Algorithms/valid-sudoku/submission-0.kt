class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val digits = CharArray(9)
        val digitsSeen = BitSet(9)

        fun validate(): Boolean {
            digitsSeen.clear()
            for (c in digits) {
                val digit = c.digitToIntOrNull() ?: continue

                if (digitsSeen.get(digit - 1)) {
                    return false
                }
                digitsSeen.set(digit - 1)
            }
            return true
        }

        // Row validation
        for (rowIndex in 0 until 9) {
            for (colIndex in 0 until 9) {
                digits[colIndex] = board[rowIndex][colIndex]
            }
            if (!validate()) {
                return false
            }
        }

        // Column validation
        for (rowIndex in 0 until 9) {
            for (colIndex in 0 until 9) {
                digits[colIndex] = board[colIndex][rowIndex]
            }
            if (!validate()) {
                return false
            }
        }

        // Box validation
        for (boxIndex in 0 until 9) {
            for (r in 0 until 3) {
                for (c in 0 until 3) {
                    val rowIndex = boxIndex / 3 * 3 + r
                    val colIndex = boxIndex % 3 * 3 + c
                    digits[r * 3 + c] = board[rowIndex][colIndex]
                }
            }
            if (!validate()) {
                return false
            }
        }

        return true
    }
}
