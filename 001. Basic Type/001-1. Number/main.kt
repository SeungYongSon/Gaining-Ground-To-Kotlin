/*
숫자

코틀린은 자바와 유사한 방법으로 숫자를 다루지만 완전히 같지는 않다.
숫자에 대해 넓은 타입으로의 자동 변환이 없고, 어떤경우에는 리터럴도 약간 다르다.

코틀린이 제공하는 숫자 내장 타입은

Dobule  - 64 bit
Float   - 32 bit
Long    - 64 bit
int     - 32 bit
Short   - 16 bit
Byte    - 8 bit

이렇게 있다.

자바와 다르게 코틀린에서는 문자(Character)는 숫자가 아니다.

*/



fun main(args: Array<String>) {

    /***** 리터럴상수 *****/

    /*
       정수 값을 위한 리터럴 상수 종류는 다음과 같다.

       십진수 : 123 (Long 은 대문자 L 로 표시 : 123L)

       16진수 : 0x0F

       2진수  : 0b00001011

       * 8 진수 리터럴은 지원하지 않는다. *


       부동소수점을 위한 표기법

       기본은 Double : 123.5  , 123.5e10
       Float 은 f 나 F 로 표시 : 123.5f
    */





    /***** 숫자 리터럴에 밑줄 넣기 *****/

    // 코틀린 1.1 버젼 부터 숫자 상수의 가독성을 높이기 위해 밑줄을 사용 할 수 있다.
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010





    /***** 표현 *****/

    // 자바 플랫폼에서는 JVM 기본 타입으로 숫자를 저장한다.
    val a: Int = 10000

    //만약 null 가능 숫자 레퍼런스(예 Int? )가 필요하거나 제네릭이 관여하면 박싱(boxing) 타입으로 저장한다.
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    // 숫자를 박싱하면 동일성(Identity)을 유지하지 않는다.
    println(a === a) // 'true' 출력
    println(boxedA === anotherBoxedA) // !!!!'false' 출력!!!!

    // 하지만 값의 동등함은 유지한다.
    println(a == a) // 'true' 출력
    println(boxedA == anotherBoxedA) // 'true' 출력





    /***** 명시적 변환 *****/

    // 표현이 다르므로 작은 타입이 큰 타입의 하위 타입은 아니다. 즉, 작은 타입을 큰 타입으로 자동으로 변환하지 않는다.
    val b: Byte = 1
    //val i: Int = b  <- 주석을 풀면 작은 타입이 큰타입으로 자동 변환 되지 않기 때문에 에러가 뜰것이다.

    val i: Int = b.toInt() // 하지만 명시적으로 넓히는 변환은 할 수 있다.
    /*
        위에 코드같이 모든 숫자 타입은 아래와 같은 명시적 변환을 지원한다.

        toByte()    : Byte
        toShort()   : Short
        toInt()     : Int
        toLong()    : Long
        toFloat()   : Float
        toDouble()  : Double
        toChar()    : Char
     */





    /***** 자동 변환 *****/

    // 자동변환의 부재를 거의 느낄 수 없는데 이유는 컨텍스트에서 추론하고 수치 연산을 변환에 알맞게 오버로딩했기 때문이다.
    val l = 1L + 3 // Long + Int => Long  그 예시다.





    /***** 연산 ******/

    // 코틀린은 숫자에 대한 표준 수치 연산을 지원한다. 이들 연산은 알맞은 클래스의 멤버로 선언되어 있다.

    // 자바와 다르게 비트 연산자를 위한 특수 문자는 없고 중의 형식으로 호출할 수 있는 함수를 제공한다.
    val x = (1 shl 2) and 0x000FF000 // 그 예시다.
    /*
        다음은 전체 비트 연산자 목록이다.(단, Int 와 Long 에서만 사용 가능하다)

        shl(bits)   : 부호있는 왼쪽 시프트(자바에서 <<)
        shr(bits)   : 부호있는 오른쪽 시프트(자바에서 >>)
        ushr(bits)  : 부호없는 오른쪽 시프트(자바에서 >>>)
        and(bits)   : 비트 AND
        or(bits)    : 비트 OR
        xor(bits)   : 비트 XOR
        inv()       : 비트 역
     */





    /***** 부동소수 비교 ******/

    /*
        실수에 대한 연산

        동등함 비교: a == b 와 a != b
        비교 연산자 : a < b , a > b , a <= b , a >= b
        범위 생성과 검사 : a..b , x in a..b , x !in a..b

     */

    // 간단한 예시들 이다.
    var sm : Int = 1
    var bg : Int = 10

    println(sm == bg) // false 출력
    println(sm != bg) // true 출력

    if(sm < bg){
        println("bg 가 더 큼")
    }else{
        println("sm 이 더 큼")
    }

    val lo  = a..b
    println(lo)

    var count = 0
    for(i in sm..bg){ // 0 부터 9 까지 출력
        println(count)
        count++
    }
}
