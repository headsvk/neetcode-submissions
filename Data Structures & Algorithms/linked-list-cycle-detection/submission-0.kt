/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next

        while (fast != null) {
            if (fast == slow) {
                return true
            }
            fast = fast?.next?.next
            slow = slow?.next
        } 
        return false
    }
}
