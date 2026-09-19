/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = hashMapOf<Node, Node>()
        val dummy = Node(0)
        
        // 1. Copy list
        var cur = head
        var prevCopy = dummy
        while (cur != null) {
            val copy = Node(cur.`val`)
            copy.random = cur.random
            prevCopy.next = copy
            prevCopy = copy
            map[cur] = copy
            cur = cur?.next
        }

        // 2. Resolve random pointers
        for (node in map.values) {
            node.random = map[node.random]
        }

        return dummy.next
    }
}
