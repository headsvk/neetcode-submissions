class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = left + (right - left) / 2
            val value = nums[mid]
            when {
                nums[mid] < nums[left] -> right = mid
                nums[left] < nums[right] -> return nums[left]
                else -> left = mid + 1
            }
        }

        return nums[left]
    }
}
