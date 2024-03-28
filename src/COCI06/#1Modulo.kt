package COCI06

//https://dmoj.ca/problem/coci06c1p1
//COCI '06 Contest 1 #1 Modulo
fun main() {
    val resultSet = mutableSetOf<Int>()
    repeat(10) {
        val number = readlnOrNull()?.toIntOrNull()
        number?.let {
            check(it in 0..1000) { "0 ~ 1000사이 양수만 와야함 : $it" }
            resultSet.add(it % 42)
        } ?: error("0 ~ 1000사이 양수만 와야함")
    }
    println(resultSet.size)
}
