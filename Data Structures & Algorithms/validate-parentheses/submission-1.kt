class Solution {
    private val mapping = mapOf('}' to '{', ')' to '(', ']' to '[')

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (c in s) {
            val toFind = mapping[c]

            when (mapping[c]) {
                null -> stack.addFirst(c)
                stack.firstOrNull() -> stack.removeFirst()
                else -> return false
            }
        }
        return stack.isEmpty()
    }
}
