package COCI07

//https://dmoj.ca/problem/coci06c2p3
//COCI '06 Contest 2 #3 Kolone

fun main(){
    val (n1, n2) = readlnOrNull()
        ?.split(" ")
        ?.mapNotNull { it.toIntOrNull() }
        ?.takeIf { it.size == 2 && it.all { num -> num in 0..10 } }
        ?: error("0부터 10까지의 숫자 두개를 입력해주세요.")

    val row1 = readlnOrNull()
        ?.validateRow(n1, "두번째 행 입력값은 알파벳 대문자로 중복되지 않게 $n1 글자 입력해주세요")
        ?: return

    val row2 = readlnOrNull()
        ?.validateRow(n2, "세번째 행 입력값은 알파벳 대문자로 중복되지 않게 $n2 글자 입력해주세요") {
            val duplicateList = it.toSet().intersect(row1.toSet())
            if (duplicateList.isNotEmpty()) error("두번째 행과 세번째 행에 중복되는 알파벳이 있습니다: $duplicateList")
        }
        ?: return

    val time = readlnOrNull()
        ?.toIntOrNull()
        ?.takeIf { it in 0..50 }
        ?:error("0~50숫자만 입력해주세요")

    var ants = row1.reversed()+row2
    repeat(time){
        var i = 0
        while (i < ants.length-1){
            if(ants[i] in row1 && ants[i+1] in row2){
                val curr = ants[i]
                val next = ants[i+1]
                val beforeStr = ants.substringBefore("$curr$next")
                val afterStr = ants.substringAfter("$curr$next")
                ants = beforeStr+next+curr+afterStr
                i += 2
            }else{
                i++
            }
        }
    }
    println(ants)
}

fun String.validateRow(length: Int, errorMessage: String, additionalValidation: (String) -> Unit = {}): String? {
    val regex = Regex("""^(?:([A-Z])(?!.*\1)){$length}${'$'}""")
    return if (regex.matches(this)) {
        additionalValidation(this)
        this
    } else {
        error(errorMessage)
    }
}