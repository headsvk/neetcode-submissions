class WordDictionary {
    
    private class TrieNode {
        // Primitive array of size 26 for 'a' through 'z'
        val children = arrayOfNulls<TrieNode>(26)
        var isEndOfWord: Boolean = false
    }

    private val root = TrieNode()

    fun addWord(word: String) {
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

    fun search(word: String): Boolean {
        return searchPartial(root, word, 0)
    }

    private fun searchPartial(node: TrieNode, word: String, start: Int): Boolean {
        var current = node
        for (i in start until word.length) {
            val c = word[i]
            if (c == '.') {
                for (child in current.children) {
                    if (child != null && searchPartial(child, word, i + 1)) {
                        return true
                    }
                }
                return false
            } else {
                val index = c - 'a'
                current = current.children[index] ?: return false
            }
        }
        return current.isEndOfWord
    }
}
