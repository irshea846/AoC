//--- Day 2: Rock Paper Scissors ---
//The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the snack storage,
// a giant Rock Paper Scissors tournament is already in progress.
//
//Rock Paper Scissors is a game between two players. Each game contains many rounds;
// in each round, the players each simultaneously choose one of Rock, Paper, or Scissors using a hand shape.
// Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
// If both players choose the same shape, the round instead ends in a draw.
//
//Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input)
// that they say will be sure to help you win.
// "The first column is what your opponent is going to play:
// A for Rock,
// B for Paper,
// C for Scissors.
//
// The second column--" Suddenly, the Elf is called away to help with someone's tent.
//
//The second column, you reason, must be what you should play in response:
// X for Rock,
// Y for Paper,
// Z for Scissors.
// Winning every time would be suspicious, so the responses must have been carefully chosen.
//
//The winner of the whole tournament is the player with the highest score.
//Your total score is the sum of your scores for each round.
//The score for a single round is the score for the shape you selected
//(
// 1 for Rock,
// 2 for Paper,
// 3 for Scissors
//)
//plus the score for the outcome of the round
//(
// 0 if you lost,
// 3 if the round was a draw,
// 6 if you won
//)
//
//Since you can't be sure if the Elf is trying to help you or trick you, you should calculate the score you would get if you were to follow the strategy guide.
//
//For example, suppose you were given the following strategy guide:
//
//A Y -> Win 2 + 6 = 8
//B X -> Lose 1 + 0 = 1
//C Z -> Draw 3 + 3 = 6
//This strategy guide predicts and recommends the following:
//
//In the first round, your opponent will choose Rock (A), and you should choose Paper (Y).
//This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
//
//In the second round, your opponent will choose Paper (B), and you should choose Rock (X).
//This ends in a loss for you with a score of 1 (1 + 0).
//
//The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
//In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).
//
//What would your total score be if everything goes exactly according to your strategy guide?

fun main() {
    fun part1(input: List<Pair<Char, Char>>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val input = readListPair("Day02")
    part1(input).println()
    println(input)

    val opponentMap = mutableMapOf<Char, Int>().apply {
        this['A'] = 1
        this['B'] = 2
        this['C'] = 3
    }

    val scoreList = listOf(0, 3, 6)
    val selfMap = mutableMapOf<Char, Int>().apply {
        this['X'] = 1
        this['Y'] = 2
        this['Z'] = 3
    }

    var score1 = 0
    input.forEach {
        val opponent = opponentMap[it.first]
        val self = selfMap[it.second]
        val diff = self!!.minus(opponent!!)
        when (diff) {
            0 -> score1 += self.plus(scoreList[1])
            -2, 1 -> score1 += self.plus(scoreList[2])
            -1, 2 -> score1 += self.plus(scoreList[0])
        }
    }
    println(score1)

    val selfMap1 = mutableMapOf<Char, Int>().apply {
        this['X'] = 0
        this['Y'] = 3
        this['Z'] = 6
    }
    var score2 = 0
    input.forEach {
        val opponent = opponentMap[it.first]
        when (selfMap1[it.second]) {
            0 -> {
                val diff = opponent!!.minus(1)
                score2 += if (diff == 0) 3 else diff
            }
            3 -> score2 += opponent!!.plus(3)
            6 -> {
                val diff = opponent!!.plus(1)
                score2 += if (diff > 3) 1 else diff
                score2 += 6
            }
        }
    }
    println(score2)

}
