/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var count = 0
    private var res = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        count = k
        res = -1
        inorder(root)
        return res
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) {
            return;
        }
        
        inorder(root.left)

        count--
        if (count == 0) {
            res = root.`val`
            return
        }

        inorder(root.right)
    }
}
