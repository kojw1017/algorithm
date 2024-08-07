package COCI064


//https://dmoj.ca/problem/coci06c3p4
//COCI '06 Contest 3 #4 Tenkici

/**
 * Consider a sequence of N integers where each integer between 1 and N appears exactly once.
 *
 * A pair of numbers in the sequence is confused
 * if the number that comes earlier in the sequence is lager than the later number.
 *
 * The confusion of the sequence is the number of confused pairs in it. For example,
 * the confusion of the sequence(1, 4, 3, 2) is 3 because there are 3 confused pairs:(4,3), (4,2) and (3, 2).
 *
 * Write a program that calculates the number of sequences of length N whose confusion is exactly C.
 *
 * Input Specification
 *
 * The first and only line of input contains two integers, N(1<=N<=1000) and C(0<=C<=10000>.
 *
 * Output Specification
 *
 * Output the number of sequences modulo 1 000 000 007.
 */

const val MOD = 1000000007

fun main() {
    val (n, C) = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(1001) { IntArray(10001) }
    dp[0][0] = 1

    for (pos in 1..n) {
        // dp[pos-1]을 누적합 전처리
        val sum = IntArray(10002)
        sum[0] = dp[pos - 1][0]
        println("dp[pos - 1][0]-> ${dp[pos - 1][0]}")
        for (j in 1..C) {
            sum[j] = (sum[j - 1] + dp[pos - 1][j]) % MOD
        }
        // dp[pos][confuse]를 구한다.
        for (confuse in 0..C) {
            dp[pos][confuse] = sum[confuse]
            if (confuse - n + pos - 1 >= 0) {
                dp[pos][confuse] = (dp[pos][confuse] - sum[confuse - n + pos - 1] + MOD) % MOD
            }
        }
    }

    println(dp[n][C])
}
