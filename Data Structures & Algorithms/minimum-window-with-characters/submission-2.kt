class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) {
            return ""
        }

        val histT = t.groupingBy { it }.eachCount()
        val histS = histT.keys.associateWithTo(HashMap(histT.size)) { 0 }

        var shortLeft = 0
        var shortSize = Int.MAX_VALUE

        var left = 0
        var right = 0
        var have = 0
        while (right < s.length) {

            val letter = s[right]
            val tCount = histT[letter]
            val sCount = histS[letter]

            if (tCount != null && sCount != null) {
                histS[letter] = sCount + 1
                if (sCount + 1 == tCount) {
                    have++
                }
            }

            if (have == histT.size) {

                do {
                    val leftLetter = s[left]
                    val leftCountT = histT[leftLetter]
                    val leftCountS = histS[leftLetter]
                    if (leftCountT != null && leftCountS != null) {
                        // Remove one
                        histS[leftLetter] = leftCountS - 1
                        if (leftCountS == leftCountT) {
                            // Removing one voided this condition
                            have--
                        }
                    }

                    left++
                } while (have == histT.size && left < s.length)
                
                // Compute size of the new match
                val size = right - left + 2
                if (size < shortSize) {
                    shortSize = size
                    shortLeft = left - 1
                }
            }
            right++
        }

        if (shortSize == Int.MAX_VALUE) {
            return ""
        }

        return s.substring(shortLeft, shortLeft + shortSize)
    }
}
