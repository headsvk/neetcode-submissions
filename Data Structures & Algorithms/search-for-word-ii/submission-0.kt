class Solution {
    private class TrieNode {
        // Primitive array of size 26 for 'a' through 'z'
        val children = arrayOfNulls<TrieNode>(26)
        var isEndOfWord: Boolean = false
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()
        for (word in words) {
            insert(root, word)
        }

        val rows = board.size
        val cols = board[0].size
        val res = HashSet<String>()
        val visit = HashSet<Pair<Int, Int>>()

        fun dfs(r: Int, c: Int, node: TrieNode, word: String) {
            if (r !in 0 until rows || c !in 0 until cols ||
               (r to c) in visit || node.children[board[r][c] - 'a'] == null) {
                return
            }

            visit.add(r to c)
            val nextNode = node.children[board[r][c] - 'a']!!
            val newWord = word + board[r][c]
            if (nextNode.isEndOfWord) {
                res.add(newWord)
            }

            dfs(r + 1, c, nextNode, newWord)
            dfs(r - 1, c, nextNode, newWord)
            dfs(r, c + 1, nextNode, newWord)
            dfs(r, c - 1, nextNode, newWord)

            visit.remove(r to c)
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                dfs(r, c, root, "")
            }
        }

        return res.toList()
    }

    private fun insert(root: TrieNode, word: String) {
        var current = root
        for (c in word) {
            val index = c - 'a'
            var next = current.children[index]
            if (next == null) {
                next = TrieNode()
                current.children[index] = next
            }
            current = next
        }
        current.isEndOfWord = true
    }
}
