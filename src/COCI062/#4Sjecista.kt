package COCI062

//https://dmoj.ca/problem/coci06c2p4
//COCI '06 Contest 2 #4 Sjecista

fun main(){
    val N = readlnOrNull()?.toIntOrNull()?.let {
        check(it in 3..100) { "3..100사이 정수만 와야함 : $it" }
        it
    }?: error("3~100 사이의 정수를 입력해주세요.")
    println(N * (N - 1) * (N - 2) * (N - 3) / 24)
}