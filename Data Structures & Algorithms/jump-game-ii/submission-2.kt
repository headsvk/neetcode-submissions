class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var left = 0
        var right = 0

        // Continue until the right boundary reaches or exceeds the target
        while (right < nums.size - 1) {
            var farthest = right

            // Process all nodes currently in the "queue" (Level k)
            for (i in left..right) {
                farthest = maxOf(farthest, i + nums[i])
            }

            // Advance to Level k + 1
            left = right + 1
            right = farthest
            jumps++
        }

        return jumps
    }
}
