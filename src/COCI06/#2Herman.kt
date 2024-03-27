package COCI06

//https://dmoj.ca/problem/coci06c1p2
//COCI '06 Contest 1 #2 Herman
fun main(){
    println((1..10).fold(0 to ""){acc, _->
        val (count, history) = acc
        val v = readlnOrNull()?.toIntOrNull()?.let{
            if(0 > it || it > 1000) throw Throwable("invalid range 1<=x<=1000: $it")
            it % 42
        } ?: throw Throwable("invalid Int")
        if("|$v|" !in history) count + 1 to "$history|$v|"
        else acc
    }.first)
}