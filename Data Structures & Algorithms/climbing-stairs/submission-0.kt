class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        var prev2 = 1 // ways to reach step 1
        var prev1 = 2 // ways to reach step 2

        repeat(n - 2) {
            val curr = prev1 + prev2
            prev2 = prev1
            prev1 = curr
        }

        return prev1
    }
}
