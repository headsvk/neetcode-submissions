class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        // n nodes, labeled 1 to n (edges.size == n)
        val parent = IntArray(edges.size + 1) { it }

        fun find(i: Int): Int {
            if (parent[i] != i) parent[i] = find(parent[i])
            return parent[i]
        }

        for (edge in edges) {
            val rootU = find(edge[0])
            val rootV = find(edge[1])

            // If both vertices already share the same root leader,
            // this edge closes the cycle!
            if (rootU == rootV) {
                return edge
            }

            // Union: merge the two components
            parent[rootU] = rootV
        }

        return intArrayOf()
    }
}
