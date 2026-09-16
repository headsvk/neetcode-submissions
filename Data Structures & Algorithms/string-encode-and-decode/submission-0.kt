class Solution {
    val delim = '%'

    fun encode(strs: List<String>): String {
        val builder = StringBuilder()

        for (str in strs) {
            builder.append(str.length)
            builder.append(delim)
            builder.append(str)
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()

        var i = 0
        while (i < str.length) {

            var j = i + 1
            while (str[j] != delim) {
                j++
            }

            val strLength = str.parseIntSubstring(i, j)

            j++
            result.add(str.substring(j, j + strLength))

            i = j + strLength
        }
        return result
    }

    fun String.parseIntSubstring(start: Int, end: Int): Int {
        var result = 0
        for (i in start until end) {
            result = result * 10 + (this[i] - '0')
        }
        return result
    }
}
