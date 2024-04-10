package COCI07

//https://dmoj.ca/problem/coci06c2p4
//COCI '06 Contest 2 #4 Sjecista

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val (m, n) = sc.nextLine().split(" ").map { it.toInt() }
    val apartment = Array(m) { sc.next() }

    var maxPerimeter = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (apartment[i][j] == '.') {
                val rect = findMaxRectangle(apartment, i, j, m, n)
                maxPerimeter = maxOf(maxPerimeter, calculatePerimeter(rect, m, n))
            }
        }
    }

    println(maxPerimeter)
}

data class Rectangle(val left: Int, val right: Int, val top: Int, val bottom: Int)

fun findMaxRectangle(apartment: Array<String>, x: Int, y: Int, m: Int, n: Int): Rectangle {
    var left = x
    var right = x
    var top = y
    var bottom = y

    // 오른쪽으로 이동하며 최대 x 좌표 찾기
    for (i in x + 1 until m) {
        if (apartment[i][y] == 'X') break
        right = i
    }

    // 왼쪽으로 이동하며 최소 x 좌표 찾기
    for (i in x - 1 downTo 0) {
        if (apartment[i][y] == 'X') break
        left = i
    }

    // 아래쪽으로 이동하며 최대 y 좌표 찾기
    for (j in y + 1 until n) {
        if (apartment[left][j] == 'X' || apartment[right][j] == 'X') break
        bottom = j
    }

    // 위쪽으로 이동하며 최소 y 좌표 찾기
    for (j in y - 1 downTo 0) {
        if (apartment[left][j] == 'X' || apartment[right][j] == 'X') break
        top = j
    }

    return Rectangle(left, right, top, bottom)
}

fun calculatePerimeter(rect: Rectangle, m: Int, n: Int): Int {
    val width = rect.right - rect.left + 1
    val height = rect.bottom - rect.top + 1

    return if (width == m || height == n) {
        2 * (width + height)
    } else {
        2 * (minOf(width, m) + minOf(height, n))
    }
}