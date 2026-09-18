class Solution {
    private val operands: Map<String, (Int, Int) -> Int> = mapOf(
        "+" to Int::plus, 
        "-" to Int::minus, 
        "*" to Int::times, 
        "/" to Int::div,
    )

    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for (token in tokens) {
            val operand = operands[token]

            if (operand != null) {
                val b = stack.removeFirst()
                val a = stack.removeFirst()
                val c = operand(a, b)
                stack.addFirst(c)
            } else {
                val number = token.toInt()
                stack.addFirst(number)
            }
        }

        return stack.first()
    }
}
