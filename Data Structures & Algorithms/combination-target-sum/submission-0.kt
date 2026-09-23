class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        // Sorting enables loop-breaking pruning
        nums.sort()

        fun backtrack(start: Int, remaining: Int) {
            if (remaining == 0) {
                result.add(ArrayList(current))
                return
            }

            for (i in start until nums.size) {
                val num = nums[i]

                // Pruning: all subsequent numbers will also be too large
                if (num > remaining) break

                current.add(num)
                
                // Recurse passing `i` (not i + 1) to allow reuse of nums[i]
                backtrack(i, remaining - num)
                
                current.removeLast()
            }
        }

        backtrack(0, target)
        return result
    }
}
