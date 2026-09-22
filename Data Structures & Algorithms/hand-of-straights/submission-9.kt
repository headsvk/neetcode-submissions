class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false
        if (groupSize == 1) return true

        hand.sort()

        // Compress adjacent duplicates into primitive parallel arrays:
        // vals[k] = card value, counts[k] = frequency
        var uniqueCount = 0
        for (i in hand.indices) {
            if (i == 0 || hand[i] != hand[i - 1]) uniqueCount++
        }

        val vals = IntArray(uniqueCount)
        val counts = IntArray(uniqueCount)
        var idx = -1

        for (card in hand) {
            if (idx == -1 || vals[idx] != card) {
                idx++
                vals[idx] = card
            }
            counts[idx]++
        }

        // Process from left to right with pure primitive indexing
        for (i in 0 until uniqueCount) {
            val needed = counts[i]
            if (needed == 0) continue

            // Check if the next (groupSize - 1) unique values match and have enough counts
            for (j in 0 until groupSize) {
                val targetIdx = i + j
                if (targetIdx >= uniqueCount) return false
                if (vals[targetIdx] != vals[i] + j) return false
                if (counts[targetIdx] < needed) return false

                counts[targetIdx] -= needed
            }
        }

        return true
    }
}
