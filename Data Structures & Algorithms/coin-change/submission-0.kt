class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0

        // dp[i] stores the minimum coins needed to make amount i
        val maxSentinel = amount + 1
        val dp = IntArray(amount + 1) { maxSentinel }
        dp[0] = 0

        for (a in 1..amount) {
            for (coin in coins) {
                if (a - coin >= 0) {
                    dp[a] = minOf(dp[a], dp[a - coin] + 1)
                }
            }
        }

        return if (dp[amount] > amount) -1 else dp[amount]
    }
}
