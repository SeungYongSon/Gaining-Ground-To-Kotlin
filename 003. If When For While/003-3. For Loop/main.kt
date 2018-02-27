/*
For 루프

코틀린에서 for 는 이터레이터를 제공하는 모든 것에 대해 반복을 수행한다.
C# 과 같은 언어의 foreach 루프와 동일하다.
*/

fun main(args: Array<String>){
    val collection = Array(5, { i ->  (i * i).toString()})

    // 기본 구조
    for(item in collection) println(item)

    val ints = intArrayOf(1,2,3,4,5,6)
    for(item: Int in ints){ // 몸체는 블록일 수 있다.
        println(item)
    }

    /*
    위에 설명한대로 for 는 이터레이터를 제공하는 모든 것에 동작한다.
    동작 조건은 이렇다.
    - 반환 유형을 가진 멤버함수를 가지고 있거나 확장된 함수 iterator()를 가지고 있다.
    - 멤버함수 또는 확장된 함수 next()를 가지고 있다.
    - Boolean 을 반환하는 멤버함수 또는 확장된 함수 hasNext()를 가지고 있다.

    이 세 함수는 모두 operator 로 지정해야한다.
    */

    // for 루프에 배열을 전달하면 특정 iterator 객체를 만들지 않을 경우 index 를 기반으로 반복된다.
    // index가 존재하는 배열이나 리스트를 반복할 경우 아래와 같이 작성할 수 있다.
    for(i in ints.indices){
        println(ints[i])
    }

    // 이처럼 범위를 통한 반복은 추가적인 객체를 생성하지않고 최적의 상태로 컴파일된다.

    // indices 대신 withIndex 라이브러리 함수를 사용해도 된다.
    for((index, value) in ints.withIndex()){
        println("the element at $index is $value")
    }
}
