import java.lang.StringBuilder

//[V]     [B]                     [F]
//[N] [Q] [W]                 [R] [B]
//[F] [D] [S]     [B]         [L] [P]
//[S] [J] [C]     [F] [C]     [D] [G]
//[M] [M] [H] [L] [P] [N]     [P] [V]
//[P] [L] [D] [C] [T] [Q] [R] [S] [J]
//[H] [R] [Q] [S] [V] [R] [V] [Z] [S]
//[J] [S] [N] [R] [M] [T] [G] [C] [D]
//1   2   3   4   5   6   7   8   9

//    [D]
//[N] [C]
//[Z] [M] [P]
//1   2   3
fun main() {

//    val stacksOfCrates: List<MutableList<Char>> = listOf(
//        mutableListOf('Z', 'N'),
//        mutableListOf('M', 'C', 'D'),
//        mutableListOf('P')
//    )
    val p1StacksOfCrates: List<MutableList<Char>> = listOf(
        mutableListOf('J', 'H', 'P', 'M', 'S', 'F', 'N', 'V'),
        mutableListOf('S', 'R', 'L', 'M', 'J', 'D', 'Q'),
        mutableListOf('N', 'Q', 'D', 'H', 'C', 'S', 'W', 'B'),
        mutableListOf('R', 'S', 'C', 'L'),
        mutableListOf('M', 'V', 'T', 'P', 'F', 'B'),
        mutableListOf('T', 'R', 'Q', 'N', 'C'),
        mutableListOf('G', 'V', 'R'),
        mutableListOf('C', 'Z', 'S', 'P', 'D', 'L', 'R'),
        mutableListOf('D', 'S', 'J', 'V', 'G', 'P', 'B', 'F')
    )

    val p2StacksOfCrates: List<MutableList<Char>> = listOf(
        mutableListOf('J', 'H', 'P', 'M', 'S', 'F', 'N', 'V'),
        mutableListOf('S', 'R', 'L', 'M', 'J', 'D', 'Q'),
        mutableListOf('N', 'Q', 'D', 'H', 'C', 'S', 'W', 'B'),
        mutableListOf('R', 'S', 'C', 'L'),
        mutableListOf('M', 'V', 'T', 'P', 'F', 'B'),
        mutableListOf('T', 'R', 'Q', 'N', 'C'),
        mutableListOf('G', 'V', 'R'),
        mutableListOf('C', 'Z', 'S', 'P', 'D', 'L', 'R'),
        mutableListOf('D', 'S', 'J', 'V', 'G', 'P', 'B', 'F')
    )

    fun getRearrangeProcedures(list: List<String>): MutableList<List<Int>> {
        val listOfRearrangeProcedures: MutableList<List<Int>> = mutableListOf()
        list.forEach {item ->
            listOfRearrangeProcedures.add(
                item.split(" ").filter {
                    it.first().isDigit()
                }.map { it.toInt() })
        }
        return listOfRearrangeProcedures

    }

    fun part1(input: List<String>): String {
        println(p1StacksOfCrates)
        val listOfMoves: MutableList<List<Int>> = getRearrangeProcedures(input)
        listOfMoves.forEach {
            val take = p1StacksOfCrates[it[1] - 1].takeLast(it[0]).reversed()
            p1StacksOfCrates[it[2] - 1].addAll(take)
            val drop = p1StacksOfCrates[it[1] - 1].dropLast(it[0])
            p1StacksOfCrates[it[1] - 1].clear()
            p1StacksOfCrates[it[1] - 1].addAll(drop)
        }
        println(p1StacksOfCrates)
        val strBuilder = StringBuilder()
        p1StacksOfCrates.forEach {
            if (it.isNotEmpty()) {
                strBuilder.append(it.last())
            }
        }
        return strBuilder.toString()
    }

    fun part2(input: List<String>): String {
        println(p2StacksOfCrates)
        val listOfMoves: MutableList<List<Int>> = getRearrangeProcedures(input)
        listOfMoves.forEach {
            //print("$it  ${p2StacksOfCrates[it[1] - 1]}  ${p2StacksOfCrates[it[2] - 1]} ---> ")
            val take = p2StacksOfCrates[it[1] - 1].takeLast(it[0])
            p2StacksOfCrates[it[2] - 1].addAll(take)
            val drop = p2StacksOfCrates[it[1] - 1].dropLast(it[0])
            p2StacksOfCrates[it[1] - 1].clear()
            p2StacksOfCrates[it[1] - 1].addAll(drop)
            //println("${p2StacksOfCrates[it[1] - 1]}  ${p2StacksOfCrates[it[2] - 1]}")
        }
        println(p2StacksOfCrates)
        val strBuilder = StringBuilder()
        p2StacksOfCrates.forEach {
            if (it.isNotEmpty()) {
                strBuilder.append(it.last())
            }
        }
        return strBuilder.toString()
    }

    val input = readInput("Day05")
    part1(input).println() //"SBPQRSCDF"
    part2(input).println() //RGLVRCQSB
}
