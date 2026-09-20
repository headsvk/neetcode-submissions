/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return diameter(root).second
    }

    private fun diameter(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return 0 to 0
        
        val (leftDepth, leftDiameter) = diameter(root.left)
        val (rightDepth, rightDiameter) = diameter(root.right)
        val diameter = maxOf(leftDiameter, rightDiameter, leftDepth + rightDepth)
        val depth = maxOf(leftDepth, rightDepth) + 1

        return depth to diameter
    }
}
