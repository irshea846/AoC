fun main() {
    fun part1(input: String): Int {
        val charSeq = input.toCharArray().toList().asSequence()
        var rounds = 3
        charSeq.windowed(4, 1, false).forEach {
            it.apply {
                val size = it.toSet().size
                if(size < 4) {
                    rounds++
                } else {
                    return ++rounds
                }
            }
        }
        return rounds
    }

    fun part2(input: String): Int {
        val charSeq = input.toCharArray().toList().asSequence()
        var rounds = 13
        //println(charSeq.windowed(14, 1, false))
        charSeq.windowed(14, 1, false).forEach {
            it.apply {
                val size = it.toSet().size
                if(size < 14) {
                    rounds++
                } else {
                    return ++rounds
                }
            }
        }
        return rounds
    }


    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
