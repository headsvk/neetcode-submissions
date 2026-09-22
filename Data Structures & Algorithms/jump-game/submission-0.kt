class Solution {
    fun canJump(nums: IntArray): Boolean {
        var jumps = 0

        for (i in 0 until nums.size - 1) {
            jumps = maxOf(jumps - 1, nums[i])
            if (jumps == 0) {
                return false
            }
        }
        return true
    }
}
