package COCI07

//https://dmoj.ca/problem/coci06c2p1
//COCI '06 Contest 2 #1 R2

/**
 *  r1과 s를 입력하면 r2를 구하는 문제
 *  r1과 s는 -1000과 1000사이의 숫자만 와야함
 *
 *  S는 (r1 + r2) / 2
 *  r2 = s * 2 - r1
 */
fun main() {
    val input = readlnOrNull() ?: error("입력이 필요합니다. -1000 ~ 1000 사이의 두 숫자를 입력해주세요.")
    val inputList = input.split(" ")
        .mapNotNull { it.toIntOrNull() }
        .takeIf { it.size == 2 }
        ?: error("-1000 ~ 1000 사이 두 개의 숫자가 와야 합니다.")
    val (r1, s) = inputList
    check(r1 in -1000..1000 && s in -1000..1000) { "-1000 ~ 1000 사이 숫자만 와야 합니다: $r1, $s" }

    val r2 = 2 * s - r1
    println(r2)
}
