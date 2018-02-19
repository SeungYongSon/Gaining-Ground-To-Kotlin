/*
불리언

Boolean 타입은 불리언을 표현하고 두 값이 존재한다.
true 와 false.

그냥 자바와 같다.
*/

fun main(args: Array<String>) {

    val tBool : Boolean = true
    val fBool : Boolean = false

    // null 가능 레퍼런스가 필요하면 불리언도 박싱된다.
    val nBool : Boolean? = tBool

    /*
        불리언에 대한 내장 연산에는 다음이 있다.

        ||      : 지연 논리합
        &&      : 지연 논리곱
        !       : 역
    */


    // 위에 설명 빼고는 자바와 거의 같다. 그래서 더 이상의 자세한 설명은 생략한다.
}