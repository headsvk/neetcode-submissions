class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val total = m + n
        val mid = total / 2

        var p1 = 0
        var p2 = 0
        var prev = 0
        var curr = 0

        // Step forward until reaching the median index
        for (i in 0..mid) {
            prev = curr
            
            curr = when {
                p1 < m && p2 < n -> if (nums1[p1] < nums2[p2]) nums1[p1++] else nums2[p2++]
                p1 < m -> nums1[p1++]
                else -> nums2[p2++]
            }
        }

        // If total length is odd, median is middle element.
        // If total length is even, median is average of two middle elements.
        return if (total % 2 != 0) {
            curr.toDouble()
        } else {
            (prev + curr) / 2.0
        }
    }
}
