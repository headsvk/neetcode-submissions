class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false

        val parent = IntArray(n) { it }
        fun find(i: Int): Int {
            if (parent[i] != i) parent[i] = find(parent[i])
            return parent[i]
        }

        for (edge in edges) {
            val rootU = find(edge[0])
            val rootV = find(edge[1])
            if (rootU == rootV) return false // cycle
            parent[rootU] = rootV
        }

        return true
    }
}
