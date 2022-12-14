fun main() {

    class Range(override val start: Int, override val endInclusive: Int): ClosedRange<Int>  {

        operator fun contains(interval: Range): Boolean {
            return interval.start >= start && interval.endInclusive <= endInclusive
        }

    }

    fun isOneRangeOverlapped(list: List<String>): Boolean {
        val listOfRanges: MutableList<Range> = mutableListOf()
        list.forEach { item ->
            item.split("-").map { it.toInt() }.apply {
                listOfRanges.add(Range(this.first(), this.last()))
            }
        }
        val diffs: MutableList<Int> = mutableListOf()
        listOfRanges.map {
            diffs.add(it.endInclusive - it.start)
        }
        return if (diffs.first() >= diffs.last()) {
            listOfRanges.last() in listOfRanges.first()
        } else {
            listOfRanges.first() in listOfRanges.last()
        }
    }

    fun part1(input: List<String>): Int {
        val listOfRangeList: List<List<String>> = input.map { it.split(",") }
        var overlap = 0
        listOfRangeList.forEach {
            overlap += if (isOneRangeOverlapped(it)) 1 else 0
        }
        return overlap
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
