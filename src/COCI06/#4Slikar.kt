package COCI06

//https://dmoj.ca/problem/coci06c1p4
//COCI '06 Contest 1 #4 Slikar
import java.util.*
data class Point(val row: Int, val col: Int)

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun bfs(map: Array<CharArray>, start: Point, end: Point): Int {
    val n = map.size
    val m = map[0].size

    val queue: Queue<Point> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }

    queue.offer(start)
    visited[start.row][start.col] = true

    var prevFlood = mutableListOf<Point>()

    for (i in 0..< n) {
        for (j in 0..< m) {
            if (map[i][j] == '*') {
                prevFlood.add(Point(i, j))
            }
        }
    }

    var minute = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0..<size) {
            val cur = queue.poll()
            if (cur == end) {
                return minute
            }
            for (j in 0..<4) {
                val newRow = cur.row + dx[j]
                val newCol = cur.col + dy[j]
                if (newRow in 0..<n && newCol in 0..<m && !visited[newRow][newCol] && map[newRow][newCol] != 'X' && map[newRow][newCol] != '*') {
                    queue.offer(Point(newRow, newCol))
                    visited[newRow][newCol] = true
                }
            }
        }
        prevFlood = floodMap(map, prevFlood)
        minute++
    }
    return -1
}

fun floodMap(map: Array<CharArray>, prevFlood: MutableList<Point>): MutableList<Point> {
    val n = map.size
    val m = map[0].size
    val currFlood = mutableListOf<Point>()

    for (coord in prevFlood) {
        for (k in 0..< 4) {
            val newRow = coord.row + dx[k]
            val newCol = coord.col + dy[k]
            if (newRow in 0 until n && newCol in 0 until m && map[newRow][newCol] == '.' && map[newRow][newCol] != 'X' && map[newRow][newCol] != 'D') {
                map[newRow][newCol] = '*'
                currFlood.add(Point(newRow, newCol))
            }
        }
    }

    return currFlood
}

fun main() {
    val (rows, cols) = readln().split(" ").map { it.toInt() }

    val map = Array(rows) { CharArray(cols) }
    for (i in 0..< rows) { map[i] = readln().toCharArray() }

    val startRow = map.indexOfFirst { it.contains('S') }
    val startCol = map[startRow].indexOfFirst { it == 'S' }
    val endRow = map.indexOfFirst { it.contains('D') }
    val endCol = map[endRow].indexOfFirst { it == 'D' }

    val result = bfs(map, Point(startRow, startCol), Point(endRow, endCol))

    if (result == -1) println("KAKTUS")
    else println(result)
}