class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var profit = 0

        for (p in prices) {
            profit = maxOf(profit, p - min)
            min = minOf(p, min)
        }

        return profit
    }
}
