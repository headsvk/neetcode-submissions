class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()
        var answer = -1

        while (left <= right) {
            val mid = left + (right - left) / 2

            val value = piles.sumBy { Math.ceilDiv(it, mid) }

            when {
                value <= h -> {
                    right = mid - 1
                    answer = mid
                }
                else -> {
                    left = mid + 1
                }
            }
        }

        return answer
    }
}
