fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<List<Int>>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readListCollection("Day01")
    val bagsOfCalories: MutableList<Int> = mutableListOf()
    input.forEach {
        var sum = 0
        it.forEach { sum += it }
        bagsOfCalories.add(sum)
    }
    println(bagsOfCalories)
    bagsOfCalories.sort()
    var sumOfTop3Bags = 0
    for (i in bagsOfCalories.size - 1 downTo bagsOfCalories.size -3) {
        sumOfTop3Bags += bagsOfCalories[i]
    }
    println(bagsOfCalories[bagsOfCalories.size - 1])
    println(sumOfTop3Bags)
}
