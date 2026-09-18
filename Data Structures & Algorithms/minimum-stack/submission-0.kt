class MinStack() {

    private data class Item(
        val value: Int,
        val min: Int,
    )

    private val stack = ArrayDeque<Item>()

    fun push(`val`: Int) {
        val min = if (stack.isNotEmpty()) {
            minOf(`val`, stack.first().min)
        } else {
            `val`
        }
        stack.addFirst(Item(`val`, min))
    }

    fun pop() {
        stack.removeFirst()
    }

    fun top(): Int {
        return stack.first().value
    }

    fun getMin(): Int {
        return stack.first().min
    }
}
