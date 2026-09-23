class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0 // max loot up to house i - 2
        var rob2 = 0 // max loot up to house i - 1

        for (num in nums) {
            // Choice: skip current house (rob2) vs rob current house (rob1 + num)
            val currentLoot = maxOf(rob2, rob1 + num)
            rob1 = rob2
            rob2 = currentLoot
        }

        return rob2
    }
}
