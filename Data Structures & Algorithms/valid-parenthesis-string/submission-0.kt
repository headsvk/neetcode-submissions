class Solution {
    fun checkValidString(s: String): Boolean {
        var minOpen = 0
        var maxOpen = 0

        for (c in s) {
            when (c) {
                '(' -> {
                    minOpen++
                    maxOpen++
                }
                ')' -> {
                    minOpen--
                    maxOpen--
                }
                '*' -> {
                    minOpen-- // Treat as ')'
                    maxOpen++ // Treat as '('
                }
            }

            // Even with every star acting as '(', too many ')' appeared
            if (maxOpen < 0) {
                return false
            }

            // We can never have fewer than 0 open brackets
            if (minOpen < 0) {
                minOpen = 0
            }
        }

        // Valid if we can balance all open brackets
        return minOpen == 0
    }
}
