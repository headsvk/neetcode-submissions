/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {

            result.add(queue.last().`val`)
            for (i in 0 until queue.size) {
                val node = queue.removeFirst()

                if (node.left != null) queue.addLast(node.left)
                if (node.right != null) queue.addLast(node.right)
            }
        }

        return result
    }
}
