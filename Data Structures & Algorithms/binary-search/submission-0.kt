class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            val value = nums[mid]
            when {
                value < target -> left = mid + 1
                value > target -> right = mid - 1
                else -> return mid
            }
        }

        return -1
    }
}
