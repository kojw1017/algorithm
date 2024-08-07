package COCI063


//https://dmoj.ca/problem/coci06c3p4
//COCI '06 Contest 3 #4 Tenkici

/**
 * Mirko found a collection of N toy tanks dating back to the Second World War
 * on his grandfather attic He promptly called his friends Slavko to play with him.
 * They made a battlefield a wooden board consisting of squares in N rows and N columns.
 *
 * Each tank can be moved to one of the four neighbouring squares in a single move
 * A tank can shoot at any square in the same row and column
 * the tank is said to be guarding the row and column it is in.
 *
 * Additionally, no two tanks can be in the same square at any time.
 *
 * After many hours of play and two previous attempts, Mirko moms yelled at them to come
 * down for lunch again, and the decided to rearrange the tanks so that each tank guards
 * a different row and column (meaning also that each row and column contains only one tank).
 *
 * Write a program that finds the minimum number of moves required to rearrange the tanks so that
 * each row and each column contains single tank, and one such shortest sequence of moves.
 *
 * Input Specification
 * The first line of input contains the integer N(3<=N<=500).
 *
 * Each of the following N lines contains two integers R and C(1<=R,C<=N),
 * the row and column of a single tank at the moment of moms call.
 * No two tanks are on the same square.
 *
 * Rows and columns ar marked 1 through N, top-douw and left-to-right.
 *
 * Output Specification
 *
 * Output the minimum number of moves (call this number K) on the first line.
 * Each of the Next K lines should contain the tank being moved to the direction it is moved in,
 * separated by a single space.
 *
 * Tanks are numbered 1 through N, in the order in which they are given in the input.
 *
 * The directions can be one of four uppercase letters: U, D, L, R.
 *
 * The sequence need not be unique.
 *
 * Scoring
 * if both the number K and the sequence of moves are correct, your program will score full points on the test case.
 *
 * if your program outputs the correct number K and does not output the sequence of moves,
 * or the sequence of moves is incorrect, you will get 60% of the points for that test case.
 *
 *
 * [빈칸, 빈칸, 빈칸, 빈칸, 탱크]
 * [빈칸, 빈칸, 빈칸, 탱크, 빈칸]
 * [빈칸, 빈칸, 탱크, 빈칸, 빈칸]
 * [빈칸, 탱크, 빈칸, 빈칸, 빈칸]
 * [탱크, 빈칸, 빈칸, 빈칸, 빈칸]
 *
 *
 * [탱크1, 탱크2, 빈칸, 빈칸, 빈칸, 빈칸]
 * [탱크3, 빈칸, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 빈칸, 탱크4]
 * [빈칸, 빈칸, 빈칸, 빈칸, 탱크5, 탱크6]
 *
 *
 * [탱크1, 빈칸, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 탱크2, 빈칸, 빈칸, 빈칸]
 * [빈칸, 탱크3, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 탱크4, 빈칸]
 * [빈칸, 빈칸, 빈칸, 탱크5, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 빈칸, 탱크6]
 *
 *
 * [탱크1, 빈칸, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 탱크2, 빈칸, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 탱크3, 빈칸, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 탱크4, 빈칸, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 탱크5, 빈칸]
 * [빈칸, 빈칸, 빈칸, 빈칸, 빈칸, 탱크6]
 *
 */
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val tanks = Array(n) { readLine()!!.split(" ").map { it.toInt() - 1 }.toList() }
    val targetRows = IntArray(n)
    val targetCols = IntArray(n)

    // 각 탱크가 이동해야 할 위치(행과 열) 결정
    for (i in 0 until n) {
        targetRows[i] = i
        targetCols[i] = i
    }

    val moves = mutableListOf<String>()
    var moveCount = 0

    for (i in 0 until n) {
        val (row, col) = tanks[i]
        val targetRow = targetRows[i]
        val targetCol = targetCols[i]

        val rowDiff = targetRow - row
        val colDiff = targetCol - col

        moveCount += abs(rowDiff) + abs(colDiff)

        repeat(abs(rowDiff)) {
            moves.add(if (rowDiff > 0) "${i+1} D" else "${i+1} U")
        }

        repeat(abs(colDiff)) {
            moves.add(if (colDiff > 0) "${i+1} R" else "${i+1} L")
        }
    }

    println(moveCount)
    moves.forEach { println("$it") }
}