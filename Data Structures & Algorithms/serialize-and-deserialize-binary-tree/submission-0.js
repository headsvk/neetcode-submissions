/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Codec {
    /**
     * Encodes a tree to a single string.
     *
     * @param {TreeNode} root
     * @return {string}
     */
    serialize(root) {
        return JSON.stringify(root);
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param {string} data
     * @return {TreeNode}
     */
    deserialize(data) {
        if (!data) return null;

        // Use the reviver function to wrap plain objects into TreeNode instances
        return JSON.parse(data, (key, value) => {
            if (value && typeof value === 'object' && 'val' in value) {
                const node = new TreeNode(value.val);
                node.left = value.left;
                node.right = value.right;
                return node;
            }
            return value;
        });
    }
}
