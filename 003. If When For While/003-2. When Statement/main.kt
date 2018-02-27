import java.lang.Integer.parseInt

/*
When 식

when 은 C와 같은 언어의 switch 연산에 해당한다.
 */


fun main(args : Array<String>){
    val x : Int = 2

    // 간단한 형식
    when(x){
        1 -> println("x == 1")
        2 -> println("x == 2")
        else ->{
            print("x is neither 1 nor 2")
        }
    }
    /*
    when 은 분기하는 조건이 충족될 때까지 모든 분기에 파라미터를 순차적으로 일치시킨다.
    식으로 사용시 조건이 충족된 분기의 값이 전체 표현식의 값이 되며, 명령문으로 사용되는 경우엔 나머지 분기를 전부 무시한다.

    when 을 식으로 사용 할 때, 모든 가능한 경우를 브렌치 조건으로 확인했는지
    컴파일러가 알 수 없는 경우 else 브렌치를 필수로 추가해야 한다.
    */

    when(x){
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    } // 여러 경우를 동일한 방법으로 처리할 경우 브렌치를 콤마로 묶을 수 있다.

    // 브렌치 조건으로 상수뿐만 아니라 임의의 식을 사용할 수 있다.
    var s : String = "2"
    when(x){
        parseInt(s) -> println("s encodes x")
        else -> println("s does not encode x")
    }

    // in , !in, 범위, 콜렉션을 사용해서 값을 검사할 수 있다.(in, !in, 범위, 콜렉션은 추후 설명 할 예정이다.)
    val validNumbers : IntRange = 2..2
    when(x){
        in 1..10 -> println("x is in the range")
        in validNumbers -> println("x is 2")
        !in 10..20 -> println("x is outsid the range")
        else -> println("none of the above")
    }

    println(hasPrefifx(x)) // is 나 !is 로 특정 타입 여부를 확인 할 수 있다. hasPrefifx() 을 보자.

    var y  = What("Kotlin")
    // if - else if 체인 대신에 when 을 사용할 수도 있다.
    when{
        y.isOdd() -> println("y is odd")
        y.isEven() -> println("y is even")
        else -> print("y is funny")
    }
}

// 스마트 변환 덕분에 추가 검사없이 타입의 메서드와 프로퍼티에 접근할 수 있다.(스마트 변환은 추후 설명 할 예정이다.)
fun hasPrefifx(x: Any) = when(x){
    is String -> x.startsWith("prefix")
    else -> false
}

// 클래스에 대해서는 추후 설명할 예정이다.
class What constructor (private var whatIsThis: String){

    fun isOdd() = when(whatIsThis){
        is String -> whatIsThis == "Odd"
        else -> false
    }

    fun isEven() = when(whatIsThis){
        is String -> whatIsThis == "Even"
        else -> false
    }
}

