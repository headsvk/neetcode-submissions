/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderMap = inorder.withIndex()
            .associate { (index, value) -> value to index }

        var preorderIndex = 0

        fun dfs(left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            }

            val value = preorder[preorderIndex++]
            val mid = inorderMap[value]!!

            val leftNode = dfs(left, mid - 1)
            val rightNode = dfs(mid + 1, right)
            
            return TreeNode(value).apply {
                this.left = leftNode
                this.right = rightNode
            }
        }

        return dfs(0, preorder.lastIndex)
    }
}
