import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun readListCollection(name: String): List<List<Int>> {
    val listOfString: List<String> =
        File("src", "$name.txt").readLines()
    if (listOfString.isEmpty()) return listOf()
    var listOfInt: MutableList<Int> = mutableListOf()
    val listOfListOfInt: MutableList<MutableList<Int>> = MutableList(0) { listOfInt }
    listOfString.forEach {
        if (it.isNotEmpty()) {
            listOfInt.add(it.toInt())
        } else {
            listOfListOfInt.add(listOfInt)
            listOfInt = mutableListOf()
        }
    }
    listOfListOfInt.add(listOfInt)
    return listOfListOfInt
}

fun readListPair(name: String): List<Pair<Char, Char>> {
    val listOfString: List<String> = readInput(name)
    var pairOfChar: Pair<Char, Char> = Pair('D', 'U')
    val listOfPairOfChar: MutableList<Pair<Char, Char>> = MutableList(0) { pairOfChar }
    listOfString.forEach {
        if (it.isNotEmpty()) {
            val listOfChar = it.split(" ")
            pairOfChar = Pair(listOfChar.first().first(), listOfChar.last().first())
            listOfPairOfChar.add(pairOfChar)
        }
    }
    return listOfPairOfChar
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
