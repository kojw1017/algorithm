package COCI062

//https://dmoj.ca/problem/coci06c2p2
//COCI '06 Contest 2 #2 ABC

/**
 *  세개의 숫자와
 *  알파벳 ABC중 랜덤으로 입력하면
 *
 *  A에 가장 작은수
 *  B에 중간수
 *  C에 큰수 넣어주는 문제
 *
 *  입력 규칙 : 숫자는 100이하, 알파벳은 대문자만 공백없이
 */
fun main() {
    val numList = readln().split(" ")
        .mapNotNull { it.toIntOrNull() }
        .sorted()
        .takeIf { it.size == 3 && it.all { num -> num in 0..100 } }
        ?: error("0부터 100까지의 숫자 세 개를 입력해주세요.")

    val abc = readlnOrNull()?.let{
        val regex = Regex("""^[ABC]{3}${'$'}""")
        check(regex.matches(it)) { "입력값은 대문자 ABC중 하나씩 세글자가 와야합니다." }
        it.toCharArray()
    }?: error("입력값은 대문자 ABC중 하나씩 세글자가 와야합니다.")

    val result = abc.map {
        when (it) {
            'A' -> numList[0]
            'B' -> numList[1]
            'C' -> numList[2]
            else -> error("입력값은 대문자 ABC중 하나씩 세글자가 와야합니다.")
        }
    }.joinToString(" ")

    println(result)
}
