/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null   

        // Step 1: Interleave cloned nodes (A -> A' -> B -> B')
        var curr = head
        while (curr != null) {
            val copy = Node(curr.`val`)
            copy.next = curr.next
            curr.next = copy
            curr = copy.next
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head
        while (curr != null) {
            val copy = curr.next
            copy?.random = curr.random?.next
            curr = copy?.next
        }

        // Step 3: Unweave original and cloned lists
        curr = head
        val copyHead = head.next
        while (curr != null) {
            val copy = curr.next
            curr.next = copy?.next
            curr = curr.next
            copy?.next = curr?.next
        }

        return copyHead
    }
}
