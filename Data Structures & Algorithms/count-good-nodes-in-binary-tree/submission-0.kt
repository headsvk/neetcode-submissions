/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return goodNodes(root, root?.`val` ?: 0)
    }

    private fun goodNodes(root: TreeNode?, min: Int): Int {
        if (root == null) {
            return 0
        }

        val currentGood = if (root.`val` >= min) 1 else 0
        val currentMin = maxOf(root.`val`, min)

        val leftGood = goodNodes(root.left, currentMin)
        val rightGood = goodNodes(root.right, currentMin)
        return leftGood + rightGood + currentGood
    }
}
