class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        fun backtrack(first: Int) {
            if (first == nums.size) {
                result.add(nums.toList())
                return
            }

            for (i in first until nums.size) {
                swap(first, i)
                backtrack(first + 1)
                swap(first, i) // Backtrack
            }
        }

        backtrack(0)
        return result
    }
}
