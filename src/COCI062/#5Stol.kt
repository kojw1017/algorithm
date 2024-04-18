package COCI062

//https://dmoj.ca/problem/coci06c2p4
//COCI '06 Contest 2 #4 Sjecista
fun main() {
    val (R, C) = readLine()!!.split(" ").map { it.toInt() }
    val grid = List(R) { readLine()!!.toCharArray().toList() }

    var maxPerimeter = 0
    for (i in 0 until R) {
        for (j in 0 until C) {
            if (grid[i][j] == '.') {
                for (dx in 0..R - i) {
                    for (dy in 0..C - j) {
                        if (isValidTable(grid, i, j, dx, dy, R, C)) {
                            val perimeter = 2 * (dx + dy)
                            maxPerimeter = maxOf(maxPerimeter, perimeter)
                        }
                    }
                }
            }
        }
    }

    println(maxPerimeter)
}

fun isValidTable(grid: List<List<Char>>, x: Int, y: Int, dx: Int, dy: Int, R: Int, C: Int): Boolean {
    for (i in x until x + dx) {
        for (j in y until y + dy) {
            if (i >= R || j >= C || grid[i][j] == 'X') {
                return false
            }
        }
    }
    return true
}