/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val list = mutableListOf<Int?>()
        fun dfs(node: TreeNode?) {
            if (node == null) {
                list.add(null)
                return
            }
            list.add(node.`val`)
            dfs(node.left)
            dfs(node.right)
        }
        dfs(root)
        
        return list.joinToString("|")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val list = data.splitToSequence('|').map {
            it.toIntOrNull()
        }.toList()
        var index = 0

        fun buildTree(): TreeNode? {
            if (index >= list.size) return null
            val valOrNull = list[index++] ?: return null

            val node = TreeNode(valOrNull)
            node.left = buildTree()
            node.right = buildTree()
            return node
        }

        return buildTree()
    }
}
