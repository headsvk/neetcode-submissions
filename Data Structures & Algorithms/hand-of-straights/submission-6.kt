class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false
        if (groupSize == 1) return true

        // Primitive sort: zero object boxing, cache-friendly
        hand.sort()

        val count = HashMap<Int, Int>(hand.size)
        for (card in hand) {
            count[card] = count.getOrDefault(card, 0) + 1
        }

        for (card in hand) {
            val currentCount = count[card] ?: 0
            if (currentCount == 0) continue // Cheap integer check, no remove() needed

            // Card MUST start a group of `groupSize`
            for (i in 0 until groupSize) {
                val nextCard = card + i
                val available = count[nextCard] ?: 0
                if (available < currentCount) return false
                
                // Just update the value in-place, no remove()
                count[nextCard] = available - currentCount
            }
        }

        return true
    }
}
