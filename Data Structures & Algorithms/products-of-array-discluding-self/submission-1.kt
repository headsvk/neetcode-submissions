class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val products = IntArray(nums.size)

        var product = 1
        for (i in nums.indices) {
            products[i] = product
            product *= nums[i]
        }

        product = 1
        for (i in nums.indices.reversed()) {
            products[i] *= product
            product *= nums[i]
        }

        return products
    }
}
