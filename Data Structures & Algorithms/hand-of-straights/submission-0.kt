class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false
        if (groupSize == 1) return true

        val count = HashMap<Int, Int>()
        for (card in hand) {
            count[card] = count.getOrDefault(card, 0) + 1
        }

        for (card in hand) {
            // Find the start of the sequence chain
            var start = card
            while (count.containsKey(start - 1)) {
                start--
            }

            // Process from start forward
            while (start <= card) {
                val times = count.getOrDefault(start, 0)
                if (times > 0) {
                    for (i in 0 until groupSize) {
                        val nextCard = start + i
                        val currentCount = count.getOrDefault(nextCard, 0)
                        if (currentCount < times) return false
                        count[nextCard] = currentCount - times
                    }
                }
                start++
            }
        }

        return true
    }
}
