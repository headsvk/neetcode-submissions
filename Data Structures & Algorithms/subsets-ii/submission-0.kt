class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        // Sorting groups duplicates together
        nums.sort()

        fun backtrack(start: Int) {
            // Every node in the decision tree represents a valid subset
            result.add(current.toList())

            for (i in start until nums.size) {
                // Skip duplicates at the same decision level
                if (i > start && nums[i] == nums[i - 1]) continue

                current.add(nums[i])
                backtrack(i + 1)
                current.removeLast()
            }
        }

        backtrack(0)
        return result
    }
}
