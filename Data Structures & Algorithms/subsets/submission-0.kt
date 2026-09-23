class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int) {
            // Every state in the decision tree is a valid subset
            result.add(ArrayList(current))

            for (i in start until nums.size) {
                // 1. Choose
                current.add(nums[i])

                // 2. Explore (move strictly forward to avoid permutations)
                backtrack(i + 1)

                // 3. Un-choose (backtrack)
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0)
        return result
    }
}
