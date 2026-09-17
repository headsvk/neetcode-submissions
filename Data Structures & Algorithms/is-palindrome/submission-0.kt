class Solution {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1

        while (start < end) {
            val a = s[start]
            if (!a.isLetterOrDigit()) {
                start++
                continue
            }

            val b = s[end]
            if (!b.isLetterOrDigit()) {
                end--
                continue
            }

            if (a.lowercaseChar() != b.lowercaseChar()) {
                return false
            }
            start++
            end--
        }

        return true
    }
}
