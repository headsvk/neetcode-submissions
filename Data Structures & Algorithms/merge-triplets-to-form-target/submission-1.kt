class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val (targetX, targetY, targetZ) = target

        var matchesX = false
        var matchesY = false
        var matchesZ = false

        for (triplet in triplets) {
            val (x, y, z) = triplet

            // Skip any triplet that exceeds target in any dimension,
            // as max operations can never reduce a value.
            if (x > targetX || y > targetY || z > targetZ) {
                continue
            }

            // Check which target dimensions this valid triplet can fulfill
            if (x == targetX) matchesX = true
            if (y == targetY) matchesY = true
            if (z == targetZ) matchesZ = true

            // Early exit: all dimensions fulfilled
            if (matchesX && matchesY && matchesZ) {
                return true
            }
        }

        // If the loop finished without triggering the early return,
        // at least one dimension could not be satisfied.
        return false
    }
}
