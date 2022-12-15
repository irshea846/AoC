@Suppress("DuplicatedCode")
fun main() {

    class Range(override val start: Int, override val endInclusive: Int): ClosedRange<Int>  {

        operator fun contains(interval: Range): Boolean {
            return interval.start >= start && interval.endInclusive <= endInclusive
        }

    }

    fun isOneRangeContained(list: List<String>): Boolean {
        val listOfContainedRanges: MutableList<Range> = mutableListOf()
        list.forEach { item ->
            item.split("-").map { it.toInt() }.apply {
                listOfContainedRanges.add(Range(this.first(), this.last()))
            }
        }
        val diffs: MutableList<Int> = mutableListOf()
        listOfContainedRanges.map {
            diffs.add(it.endInclusive - it.start)
        }
        return if (diffs.first() >= diffs.last()) {
            listOfContainedRanges.last() in listOfContainedRanges.first()
        } else {
            listOfContainedRanges.first() in listOfContainedRanges.last()
        }
    }

    fun part1(input: List<String>): Int {
        val listOfRangeList: List<List<String>> = input.map { it.split(",") }
        var contain = 0
        listOfRangeList.forEach {
            contain += if (isOneRangeContained(it)) 1 else 0
        }
        return contain
    }

    fun isRangeOverlapped(list: List<String>): Boolean {
        val listOfOverlappedRanges: MutableList<Range> = mutableListOf()
        list.forEach { item ->
            item.split("-").map { it.toInt() }.apply {
                listOfOverlappedRanges.add(Range(this.first(), this.last()))
            }
        }
        val diffs: MutableList<Int> = mutableListOf()
        listOfOverlappedRanges.map {
            diffs.add(it.endInclusive - it.start)
        }
        return if (diffs.first() >= diffs.last()) {
            listOfOverlappedRanges.last().start in listOfOverlappedRanges.first() ||
                    listOfOverlappedRanges.last().endInclusive in listOfOverlappedRanges.first()
        } else {
            listOfOverlappedRanges.first().start in listOfOverlappedRanges.last() ||
                    listOfOverlappedRanges.first().endInclusive in listOfOverlappedRanges.last()
        }
    }

    fun part2(input: List<String>): Int {
        val listOfRangeList: List<List<String>> = input.map { it.split(",") }
        var overlap = 0
        listOfRangeList.forEach {
            overlap += if (isRangeOverlapped(it)) 1 else 0
        }
        return overlap
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
