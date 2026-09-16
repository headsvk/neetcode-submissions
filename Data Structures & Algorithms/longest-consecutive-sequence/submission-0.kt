class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hashset = nums.toHashSet()
        var highest = 0

        for (n in nums) {
            if (hashset.contains(n - 1)) continue

            var count = 1
            while (hashset.contains(n + count)) {
                count++
            }

            if (count > highest) {
                highest = count
            }
        }

        return highest
    }
}
