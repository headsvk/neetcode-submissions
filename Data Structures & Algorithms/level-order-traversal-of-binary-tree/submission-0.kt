/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {

            val level = mutableListOf<Int>()
            for (i in 0 until queue.size) {
                val node = queue.removeFirst()
                level.add(node.`val`)

                if (node.left != null) queue.addLast(node.left)
                if (node.right != null) queue.addLast(node.right)
            }
            result.add(level)
        }

        return result
    }
}
