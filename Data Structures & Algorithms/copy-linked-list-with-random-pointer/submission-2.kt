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

        val map = hashMapOf<Node, Node>()

        fun getCopy(node: Node?): Node? {
            if (node == null) return null
            return map.getOrPut(node) { Node(node.`val`) }
        }

        var curr = head
        while (curr != null) {
            val copy = getCopy(curr)!!
            copy.next = getCopy(curr.next)
            copy.random = getCopy(curr.random)
            curr = curr.next
        }

        return map[head]
    }
}
