import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) : String = File("src", "$name.txt")
    .readText()


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
