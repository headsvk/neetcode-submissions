class TimeMap() {

    private data class Item(val value: String, val timestamp: Int)

    private val map = mutableMapOf<String, MutableList<Item>>()

    fun set(key: String, value: String, timestamp: Int) {
        val items = map.getOrPut(key) { mutableListOf<Item>() }
        items.add(Item(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val items = map[key] ?: return ""

        val index = items.binarySearchBy(timestamp) { it.timestamp }
        val normalized = if (index >= 0) index else index.inv() - 1

        return if (normalized < 0) "" else items[normalized].value
    }
}
