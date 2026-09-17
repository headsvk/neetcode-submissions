class Solution {
    fun trap(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var maxL = height[l]
        var maxR = height[r]
        var sum = 0

        while (l < r) {
            if (maxL <= maxR) {
                l++
                maxL = maxOf(maxL, height[l])
                sum += maxL - height[l]
            } else {
                r--
                maxR = maxOf(maxR, height[r])
                sum += maxR - height[r]
            }
        }
        return sum
    }
}
