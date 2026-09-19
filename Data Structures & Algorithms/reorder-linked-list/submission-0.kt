/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // 1. Find middle (start fast at head)
        var slow = head
        var fast = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // 2. Split and reverse second half
        var second = slow?.next
        slow?.next = null // Terminate first half

        var prev: ListNode? = null
        var curr = second

        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }

        // 3. Merge two halves
        var l1 = head
        var l2 = prev // Head of reversed second half

        while (l2 != null) {
            val l1Next = l1?.next
            val l2Next = l2.next

            l1?.next = l2
            l2.next = l1Next

            l1 = l1Next
            l2 = l2Next
        }
    }
}
