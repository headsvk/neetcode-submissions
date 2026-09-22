class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var sum = 0

        for (num in nums) {
            if (sum < 0) {
                sum = 0
            }
            sum += num
            if (sum > maxSum) {
                maxSum = sum
            }
        }

        return maxSum
    }
}
