class PrefixTree {
    private class TrieNode {
        // Primitive array of size 26 for 'a' through 'z'
        val children = arrayOfNulls<TrieNode>(26)
        var isEndOfWord: Boolean = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (i in 0 until word.length) {
            val index = word[i] - 'a'
            var next = current.children[index]
            if (next == null) {
                next = TrieNode()
                current.children[index] = next
            }
            current = next
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return findNode(word)?.isEndOfWord == true
    }

    fun startsWith(prefix: String): Boolean {
        return findNode(prefix) != null
    }

    private fun findNode(prefix: String): TrieNode? {
        var current = root
        for (i in 0 until prefix.length) {
            val index = prefix[i] - 'a'
            current = current.children[index] ?: return null
        }
        return current
    }
}
