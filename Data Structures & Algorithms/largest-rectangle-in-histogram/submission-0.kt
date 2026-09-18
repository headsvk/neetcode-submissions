class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val stack = ArrayDeque<Int>()
        var maxSize = 0

        for (i in 0..n) {
            while (stack.isNotEmpty() && (i == n || heights[i] < heights[stack.first()])) {
                val height = heights[stack.removeFirst()]
                val width = if (stack.isEmpty()) i else i - stack.first() - 1
                maxSize = maxOf(maxSize, width * height)
            }
            stack.addFirst(i)
        }

        return maxSize
    }
}
