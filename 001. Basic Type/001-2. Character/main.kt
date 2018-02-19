/*
문자

Char 타입으로 문자를 표현한다. 이 타입을 바로 숫자로 다룰 수 없다.

*/


// Char 타입이 바로 숫자로 다룰 수 없다는 것을 보여주는 예시 함수다.
fun check(c: Char){
    // if(c == 1)  <- ERROR : 비호환 타입이다. 바로 숫자로 다룰 수 없기 때문이다 .
    println(c.toInt())
    if(c.toInt() == 49){ // 그래도 문자를 Int 숫자로 명시적으로 변환 할 수 있다.
        println("c -> ${c.toInt()} == '1'")
    }
}


// 문자를 숫자로 명시적 변환 시켜 Int 값으로 리턴 해주는 예시 함수다.
fun decimalDigitValue(c: Char): Int{
    if(c !in '0'..'9') // 만약 c 가 '0' ~ '9' 범위에 문자가 아니라면 IllegalArgumentException 을 걸어서 예외처리 시킨다.
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 숫자로 명시적 변환
}

fun main(args: Array<String>) {

    val One : Char = '1'
    if(One == '1'){ // 문자 리터럴은 작은 따옴표 안에 표시한다.
        println("One: $One")
        check(One) // 'c : 1' 이 출력
    }

    val Five : Char = '5'
    println(decimalDigitValue(Five))

    /*
        자바와 같이 특수 문자를 역슬래시로 표시한다.

        다음 특수문자를 지원한다.

        \t          : 탭
        \b          :
        \n          : 개행
        \r          :
        \'          : 작은 따옴표 출력
        \"          : 큰 따옴표 출력
        \\          : \ 출력
        \$          : $ 출력
    */

    //만약 임의의 문자를 인코딩 하려면 유니코드 표기법을 사용한다.
    println('\uFF00') //그 예시다

    //  숫자와 마찬가지로, 문자도 null 가능 레퍼런스가 필요하면 박싱된다.
    val c: Char = 'C'

    val boxedC: Char? = c
    val anotherBoxedC: Char? = c

    // 박싱 연산을 하면 동일성은 유지되지 않는다.
    println(boxedC === anotherBoxedC)

    // 하지만 값의 동등함은 유지한다.
    println(boxedC == anotherBoxedC)
}