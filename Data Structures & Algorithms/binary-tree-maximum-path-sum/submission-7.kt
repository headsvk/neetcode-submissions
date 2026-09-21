/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun maxPathSum(root: TreeNode?): Int {
        var maxTree = Int.MIN_VALUE

        fun dfs(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            val leftMax = maxOf(dfs(node.left), 0)
            val rightMax = maxOf(dfs(node.right), 0)
            val full = node.`val` + leftMax + rightMax
            
            maxTree = maxOf(maxTree, full)
            return node.`val` + maxOf(leftMax, rightMax)
        }

        dfs(root)
        return maxTree
    }
}
