class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false
        if (groupSize == 1) return true

        // Count card frequencies
        val count = HashMap<Int, Int>()
        for (card in hand) {
            count[card] = count.getOrDefault(card, 0) + 1
        }

        // Sort to always pick the smallest available card
        hand.sort()

        for (card in hand) {
            val available = count.getOrDefault(card, 0)
            if (available == 0) continue // Already used in an earlier group

            // `card` must start a group of length `groupSize`
            for (i in 0 until groupSize) {
                val nextCard = card + i
                val currentCount = count.getOrDefault(nextCard, 0)

                if (currentCount < available) {
                    // Not enough consecutive cards to form the groups
                    return false
                }

                count[nextCard] = currentCount - available
            }
        }

        return true
    }
}
