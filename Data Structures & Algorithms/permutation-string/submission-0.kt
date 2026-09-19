class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }

        val hist1 = IntArray(26)
        val hist2 = IntArray(26)
        
        for (i in s1.indices) {
            hist1[s1[i] - 'a']++
            hist2[s2[i] - 'a']++
        }

        if (hist1.contentEquals(hist2)) {
            return true
        }

        for (i in s1.length until s2.length) {
            hist2[s2[i - s1.length] - 'a']--
            hist2[s2[i] - 'a']++

            if (hist1.contentEquals(hist2)) {
                return true
            }
        }
        return false
    }
}
