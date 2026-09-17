class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableSetOf<List<Int>>()
        val target = 0

        var i = 0
        while (i < nums.size - 2) {
            var j = i + 1
            var k = nums.size - 1

            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]

                if (sum < target) {
                    j++
                } else if (sum > target) {
                    k--
                } else {
                    val found = listOf(nums[i], nums[j], nums[k])
                    result.add(found)
                    j++
                    k--
                }
            }
            
            i++
        }

        return result.toList()
    }
}
