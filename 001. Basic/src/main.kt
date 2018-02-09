// 패키지 정의는 소스 파일의 처음에 위치해야 한다.
import java.util. *

class Rectangle{
    var x : Int
    fun Rectangle()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int) = a - b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSub(a: Int, b: Int) {
    println("sub of $a and $b is ${a - b}")
}

fun maxOf(a: Int, b: Int): Int {
    if(a > b){
        return a
    } else{
        return b
    }
}

fun anotherMaxOf(a: Int, b: Int) = if(a > b) a else b

fun parseInt(str: String): Int? {
    return null
}

fun printProduct(arg1: String, arg2: String){
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x != null && y != null){
        println(x * y)
    }else{
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun anotherPrintProduct(arg1: String, arg2: String){
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if(x == null){
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if(y == null){
        println("Wrong number format in arg1: '$arg2'")
        return
    }
    println(x * y)
}

fun getStringLength(obj: Any): Int? {
    if(obj is String){
        return obj.length
    }
    return null
}

fun anotherGetStringLength(obj: Any): Int? {
    if(obj !is String) return null
    return obj.length
}

fun anotherAnotherGetStringLength(obj: Any): Int? {
    if(obj is String && obj.length > 0){
        return obj.length
    }
    return null
}

fun describe(obj: Any): String =
        when(obj){
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a String"
            else -> "Unknown"
        }

fun main(args: Array<String>){
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3

    var x = 5
    x += 1

    var d = 1
    val s1 = "a is $a"

    d = 2

    val s2 = "${s1.replace("is", "was")}, but now is $d"

    val items = listOf("apple", "banana", "kiwi")

    for(item in items){
        println(item)
    }

    for(index in items.indices){
        println("item at $index is ${items[index]}")
    }

    var index = 0
    while(index < items.size){
        println("item at $index is ${items[index]}")
        index++
    }

    val y = 10
    val z = 9
    if(y in 1..z+1){
        println("fits in range")
    }

    val list = listOf("a", "b", "c")

    if(-1 !in 0..list.lastIndex){
        println("-1 is out of range")
    }
    if(list.size !in list.indices){
        println("list size is out of valid list indices range too")
    }

    for(x in 1..5){
        print(x)
    }
    println()

    for(x in 1..10 step 2){
        print(x)
    }
    for(x in 9 downTo 0 step 3){
        print(x)
    }

    for(item in items){
        println(item)
    }

    when{
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}