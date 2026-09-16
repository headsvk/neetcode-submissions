class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()

        nums.forEachIndexed { bindex, b ->
            val aindex = seen[target - b]
            if (aindex != null) {
                return intArrayOf(aindex, bindex)
            }
            seen[b] = bindex
        }
        return intArrayOf()
    }
}
