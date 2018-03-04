/*
클래스

코틀린에서 클래스는 class 키워드를 사용해서 선언한다.
클래스 선언은 클래스 이름과 클래스 헤더, 중괄호로 둘러싼 클래스 몸체로 구성된다.

class Invoice{
}

클래스 멤버는 다음과 같다.
- 생성자와 초기화 블록
- 함수
- 프로퍼티
- 중첩 클래스와 내부 클래스
- 오브젝트 선언
*/



// 헤더와 몸체는 선택적이다. 클래스 몸체가 없으면 중괄호를 생략 할 수 있다.
class Empty

/***** 생성자 *****/
// 코틀린 클래스는 주요(primary) 생성자와 한 개 이상의 보조(secondary) 생성자를 가질 수 있다.


/***** 주요 생성자 *****/
// 주요 생성자는 클래스 헤더의 한 부분으로 클래스 이름(그리고 필요에 따라 타입 파라미터) 뒤에 위치한다.
class WhatName(firstname: String){
}

// 주요 생성자는 어떤 코드도 포함 할 수 없다.
// 하지만 초기화 블록에 초기화 코드가 위치 할 수 있다.
class Customer(name: String){
    init { // 초기화 블록에는 init 키워드를 접두사로 붙인다.
        println("Customer initialized with value ${name}")
        val customerKey = name.toUpperCase() // 초기화 블록에서 주요 생성자의 파라미터를 사용 할 수 있다.
    }
    // 주요 생성자 파라미터는 클래스 몸체에 선언한 프로퍼티 초기화에서도 사용할 수 있다
    val loadName = name
}

// 일반 프로피터와 마찬가지로 주요 생성자에 선언한 프로퍼티는 수정가능(var) 이거나 읽기 전용(val)일 수 있다.
class PersonInfo(val firstName: String, val lastName: String, var age: Int){
}

// 생성자가 애노테이션이나  가시성 수식어(접근 제한자를 말한다. 추 후 좀 더 자세히 설명 할 것이다.)를 가지면
// constructor 키워드가 필요하며, 키워드 앞에 수식어가 온다.
class AnoCustomer public constructor(name: String){
}



/***** 보조 생성자 *****/
// 클래스는 보조 생성자를 선언 할 수 있다.
class Person{
    constructor(parent: Person){ // 보조 생성자는 constructor 를 접두사로 붙인다.
    }
}

// 클래스에 주요 생성자가 있다면,
// 각 보조 생성자는 직접적으로 또는 다른 보조 생성자를 통해 간접적으로 주요 생성자를 호출해야한다.
class otherPerson(val name: String){
    init {
        println("name : $name")
    }

    constructor(name: String, age: Int) : this(name){ // 같은 클래스의 다른 생성자를 호출할 때는 this 키워드를 사용한다.
        println(message = "name : $name , age : $age")
    }
}

// 비추상 클래스에 어떤 생성자(주요 또는 보조)도 없으면, 인자가 없는 주요 생성자를 생성한다.
class DonCreateMe private constructor(){
    init {
        println("Why Make Me?")
    }
}


fun main(args: Array<String>){

    /***** 클래스 인스턴스 생성 *****/
    // 클래스의 인스턴스를 생성하려면 일반 함수와 같이 생성자를 호출한다.
    // 코틀린에는 new 키워드가 없음을 유의하자
    val customer = Customer("Kotiln")
    val person = otherPerson("JAVA")
    val otherPerson = otherPerson("JVM", 17)
}