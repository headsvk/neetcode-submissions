class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<Map<Char, Int>, MutableList<String>>()

        for (str in strs) {
            val histogram = str.groupingBy { it }.eachCount()

            val anagrams = map.getOrPut(histogram) { mutableListOf() }
            anagrams.add(str)
        }

        return map.values.toList()
    }
}
