class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val current = mutableListOf<String>()

        fun isPalindrome(left: Int, right: Int): Boolean {
            var l = left
            var r = right
            while (l < r) {
                if (s[l] != s[r]) return false
                l++
                r--
            }
            return true
        }

        fun backtrack(start: Int) {
            // Base case: processed the entire string successfully
            if (start == s.length) {
                result.add(current.toList())
                return
            }

            for (end in start until s.length) {
                // Prune invalid cuts early
                if (!isPalindrome(start, end)) continue

                // 1. Choose: slice and add the valid palindrome substring
                current.add(s.substring(start, end + 1))

                // 2. Explore: continue partitioning the remainder of the string
                backtrack(end + 1)

                // 3. Un-choose
                current.removeLast()
            }
        }

        backtrack(0)
        return result
    }
}
