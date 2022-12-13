fun main() {
    fun getSumOfProiorities(itemList: MutableList<Char>): Int {
        //println("${itemList.size} - $itemList")
        var sum = 0
        for (item in itemList) {
            when (item) {
                in 'a'..'z' -> sum += 1 + (item - 'a')
                in 'A'..'Z' -> sum += 27 + (item - 'A')
            }
        }
        return sum
    }

    fun part1(input: List<String>): Int {
        val listOfListOfSplitStr = input.map { it.chunked(it.length/2) }
        val itemList: MutableList<Char> = MutableList(0) {' '}
        listOfListOfSplitStr.forEach { list ->
            val sortedSets = list.map { it.toCharArray().sorted().toSet() }
            sortedSets.apply {
                this.first().forEach {
                    if (this.last().contains(it)) {
                        itemList.add(it)
                    }
                }
            }
        }
        return getSumOfProiorities(itemList)
    }

    fun part2(input: List<String>): Int {
        val listOfSets = input.map { it.toCharArray().sorted().toSet() }
        val listOfSplitSets = listOfSets.chunked(listOfSets.size/100)
        val itemList: MutableList<Char> = MutableList(0) {' '}
        listOfSplitSets.forEach { list ->
            run {
                list.first().forEach {
                    if (list.last().contains(it) && list[1].contains(it)) {
                        itemList.add(it)
                    }
                }
            }
        }
        return getSumOfProiorities(itemList)
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()

}
