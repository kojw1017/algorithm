package COCI06

//https://dmoj.ca/problem/coci06c1p1
//COCI '06 Contest 1 #1 Modulo
fun main(){
    fun numberValidator(){

    }
    val resultSet = mutableSetOf<Int>()
    try {
        repeat(10) {
            readlnOrNull()?.toIntOrNull()?.also {
                require(it in 0..1000) { "0 ~ 1000사이 양수만 와야함 : $it" }
                resultSet.add(it % 42)
            }?: throw IllegalArgumentException("0 ~ 1000사이 양수만 와야함")
        }
        println(resultSet.size)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
