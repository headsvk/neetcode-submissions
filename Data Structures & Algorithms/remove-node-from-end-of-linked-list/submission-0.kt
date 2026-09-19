/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val target = length(head) - n

        val dummy = ListNode(0)
        dummy.next = head
        var cur = head
        var prev = dummy

        var i = 0
        while (cur != null && i < target) {
            prev = cur
            cur = cur.next
            i++
        }

        prev?.next = cur?.next
        return dummy.next
    }

    private fun length(head: ListNode?): Int {
        var cur = head
        var i = 0
        while (cur != null) {
            i++
            cur = cur.next
        }
        return i
    }
}
