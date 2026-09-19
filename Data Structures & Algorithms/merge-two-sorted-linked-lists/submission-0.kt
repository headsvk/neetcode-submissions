/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var a = list1
        var b = list2
        val dummy = ListNode(0)
        var cur = dummy

        while (a != null && b != null) {
            if (a.`val` < b.`val`) {
                cur.next = a
                a = a.next
            } else {
                cur.next = b
                b = b.next
            }

            cur = cur.next!!
        }

        // attach the leftover list
        cur.next = a ?: b

        return dummy.next
    }
}
