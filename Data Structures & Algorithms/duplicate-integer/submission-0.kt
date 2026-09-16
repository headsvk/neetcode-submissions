class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}
