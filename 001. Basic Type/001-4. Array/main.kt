/*
배열

코틀린은 Array 클래스로 배열을 표현한다.

Array 클래스는 get 과 set 함수, size 프로퍼티와 그외 유용한 멤버 함수를 제공한다.
(get 과 set 은 연산자 오버로딩 관례에 따라 [] 로 바뀌었다.)

아래는 그 예시 코드다.
class Array<T> private constructor() {
    val size: Int
    operator fun get(index: Int): T
    operator fun set(index: Int, value: T): Unit
    operator fun iterator(): Iterator<T>
    // ...
}

*/


fun main(args : Array<String>){

    /***** 배열 만들기 *****/

    // 배열을 만드는 방법에는 3가지가 있다.

    // arrayOf() 사용
    val aO = arrayOf(1, 2, 3) // [1, 2, 3] 배열을 생성한다.

    // Array 생성자 이용
    val asc = Array(5, { i ->  (i * i).toString()}) // ["0", "1", "4", "9", "16"] 배열이 만들어진다.

    // arrayOfNulls() : 이 라이브러리 함수를 사용하면 주어진 크기의 null 로 채운 배열이 생성된다.
    val aN = arrayOfNulls<Int>(5)


    /*
        자바와 달리 코틀린은 배열은 변하지 않는다.
        다시말해 Array<String> 을 Array<Any> 에 대입할수 없음을 말한다.
        이는 런타임 실패을 방지하는 역할을 한다.

        그래도 Type Projection 을 통해 Array<out Any>는 대입 할 수 있는 방법이 있다고 한다.


        코틀린 또한 ByteArray , ShortArray , IntArray 등 기본 타입의 배열을 표현하기 위한 특수 클래스를 제공한다.
        이들 클래스는 Boxing 오버헤드가 없고, 이 클래스는 Array 클래스와 상속 관계가 있지 않지만 같은 메서드와 프로퍼티를 제공한다.
        그리고 각 배열 타입을 위한 팩토리 메소드를 가지고 있다.

    */



    /***** get() , set() -> [] *****/

    // 위에서 적혀 있는 거 처럼 [] 연산자는 get() 과 set() 멤버 함수 호출을 의미한다.

    // 결국 [] 연산자를 사용하면 get, set 을 호출 할 수 있다는 거다.
    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]  // 그 예시다. set 과 get 을 []을 통해 호출한다.
}

