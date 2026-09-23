class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        // 1. Sort to group duplicates and enable pruning
        candidates.sort()

        fun backtrack(start: Int, remaining: Int) {
            if (remaining == 0) {
                result.add(ArrayList(current))
                return
            }

            for (i in start until candidates.size) {
                val num = candidates[i]

                // Pruning: no need to continue since candidates are sorted
                if (num > remaining) break

                // Skip duplicate choices at the same decision level
                if (i > start && num == candidates[i - 1]) continue

                current.add(num)

                // Recurse to i + 1 because each candidate index can only be used once
                backtrack(i + 1, remaining - num)

                current.removeLast()
            }
        }

        backtrack(0, target)
        return result
    }
}
