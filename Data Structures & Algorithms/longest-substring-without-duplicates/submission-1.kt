class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var left = 0
        var res = 1
        val map = hashMapOf<Char, Int>()

        for (right in s.indices) {
            val foundIndex = map[s[right]]
            if (foundIndex != null) {
                left = maxOf(foundIndex + 1, left)
            }
            map[s[right]] = right
            res = maxOf(res, right - left + 1)
        }

        return res
    }
}
