package COCI061

//https://dmoj.ca/problem/coci06c1p2
//COCI '06 Contest 1 #2 Herman
fun main(){
    // 반지름 입력
    val r = readlnOrNull()?.toIntOrNull()?.let {
        check(it in 1..10000) { "1 ~ 10000사이 양수만 와야함 : $it" }
        it
    } ?: error("1 ~ 10000사이 양수만 와야함")

    // 유클리드 기하학에서 원의 면적
    val euclideanArea = Math.PI * r * r

    // 택시 기하학에서 원의 면적
    val taxiArea = 2.0 * r * r

    // 결과 출력
    println("%.6f".format(euclideanArea))
    println("%.6f".format(taxiArea))
}