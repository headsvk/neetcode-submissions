class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right unsorted portion
                left = mid + 1
            } else {
                // Minimum is mid or to the left of mid
                right = mid
            }
        }

        return nums[left]
    }
}
