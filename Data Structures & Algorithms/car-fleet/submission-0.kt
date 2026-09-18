class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = Array(position.size) { it }
        cars.sortByDescending { position[it] }

        var fleets = 0
        var maxTime = 0.0
        for (i in cars) {
            val time = (target - position[i]) / speed[i].toDouble()
            if (time > maxTime) {
                fleets++
                maxTime = time
            }
        }

        return fleets
    }
}
