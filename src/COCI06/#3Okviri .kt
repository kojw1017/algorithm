package COCI06

//https://dmoj.ca/problem/coci06c1p3
//COCI '06 Contest 1 #3 Okviri
fun main() {
    val regex = Regex("""^[A-Za-z]{1,15}${'$'}""")
    readlnOrNull()?.let{ input ->
        //밸리 체크
        check(regex.matches(input)){ "입력은 알파벳만 최대 15개까지 가능" }
        val charArray = input.toCharArray()
        val frames = listOf(
            listOf("..#..", ".#.#.", "#.X.#", ".#.#.", "..#.."),
            listOf("..*..", ".*.*.", "*.X.*", ".*.*.", "..*..")
        )
        repeat(5){ count ->
            var nextThirdIdx = -1
            charArray.forEachIndexed { idx, c ->
                //세번째 인지
                val isThird = idx % 3 == 2
                //세번째면 다음 idx를 기억한다
                nextThirdIdx = if(isThird) idx+1 else nextThirdIdx
                //프레임 가져오기
                val frame = if (isThird) frames[1][count] else frames[0][count]
                //X를 인풋값으로 바꾸고 프린트
                frame.replace("X", "$c").also{
                    when {
                        //세번째 다음 idx이면서 마지막이면
                        idx == nextThirdIdx && idx == charArray.lastIndex -> print(it.drop(1))
                        //세번째거나 마지막이면
                        isThird || idx == charArray.lastIndex -> print(it)
                        //세번째 다음 idx이면
                        idx == nextThirdIdx -> print(it.drop(1).dropLast(1))
                        //나머지
                        else -> print(it.dropLast(1))
                    }
                }
            }
            println()
        }
    }
}