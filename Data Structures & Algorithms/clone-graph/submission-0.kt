/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        // Key: original node reference, Value: cloned node reference
        val visited = HashMap<Node, Node>()

        fun dfs(curr: Node): Node {
            // Cycle break: if already cloned, return the memoized instance
            visited[curr]?.let { return it }

            // 1. Allocate the clone and register it BEFORE recursing into neighbors
            val copy = Node(curr.`val`)
            visited[curr] = copy

            // 2. Clone and attach all neighbor references
            for (neighbor in curr.neighbors) {
                if (neighbor != null) {
                    copy.neighbors.add(dfs(neighbor))
                }
            }

            return copy
        }

        return dfs(node)
    }
}
