class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix.first().size
        var left = 0
        var right = m * n - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val value = matrix[mid / n][mid % n]
            when {
                value < target -> left = mid + 1
                value > target -> right = mid - 1
                else -> return true
            }
        }

        return false
    }
}
