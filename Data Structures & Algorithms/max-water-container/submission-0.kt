class Solution {
    fun maxArea(heights: IntArray): Int {
        var i = 0
        var j = heights.size - 1
        var max = 0

        while (i < j) {
            val left = heights[i]
            val right = heights[j]

            val size = (j - i) * min(left, right)
            max = maxOf(size, max)

            if (left > right) {
                j--
            } else {
                i++
            }
        }

        return max
    }
}
