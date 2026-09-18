class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.isEmpty()) {
            return IntArray(0)
        }

        val output = IntArray(temperatures.size)

        val stack = ArrayDeque<Int>()

        for (i in temperatures.lastIndex downTo 0) {
            val temp = temperatures[i]

            while (stack.isNotEmpty() && temperatures[stack.first()] <= temp) {
                stack.removeFirst()
            }

            if (stack.isNotEmpty()) {
                output[i] = stack.first() - i
            } else {
                // Value not found
                output[i] = 0
            }
            stack.addFirst(i)
        }

        return output
    }
}
