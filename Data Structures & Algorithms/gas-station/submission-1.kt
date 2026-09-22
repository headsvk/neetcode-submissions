class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalTank = 0
        var currentTank = 0
        var startIndex = 0

        for (i in gas.indices) {
            val delta = gas[i] - cost[i]
            totalTank += delta
            currentTank += delta

            // If we run out of gas reaching the next station:
            // No station from `startIndex` to `i` can work.
            if (currentTank < 0) {
                startIndex = i + 1
                currentTank = 0
            }
        }

        // If total gas < total cost, impossible anywhere.
        // Otherwise, startIndex is guaranteed to be valid.
        return if (totalTank >= 0) startIndex else -1
    }
}
