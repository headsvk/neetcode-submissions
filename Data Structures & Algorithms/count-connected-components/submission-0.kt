class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        var count = n

        // 3-line find with path compression
        fun find(i: Int): Int {
            if (parent[i] != i) parent[i] = find(parent[i])
            return parent[i]
        }

        for (edge in edges) {
            val rootU = find(edge[0])
            val rootV = find(edge[1])

            // If roots differ, two components merge into one
            if (rootU != rootV) {
                parent[rootU] = rootV
                count--
            }
        }

        return count
    }
}
