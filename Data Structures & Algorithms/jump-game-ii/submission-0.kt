class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentEnd = 0
        var farthest = 0

        // Loop until the second-to-last element
        for (i in 0 until nums.size - 1) {
            farthest = maxOf(farthest, i + nums[i])

            // If we reach the end of the current jump's reach,
            // we MUST take another jump
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest

                // Early exit: we can already reach or pass the last index
                if (currentEnd >= nums.size - 1) {
                    break
                }
            }
        }

        return jumps
    }
}
