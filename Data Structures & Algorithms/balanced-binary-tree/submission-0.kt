/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != -1
    }

    private fun checkHeight(node: TreeNode?): Int {
        if (node == null) return 0

        val left = checkHeight(node.left)
        if (left == -1) return -1 // Short-circuit early

        val right = checkHeight(node.right)
        if (right == -1) return -1 // Short-circuit early

        if (abs(left - right) > 1) return -1

        return maxOf(left, right) + 1
    }
}
