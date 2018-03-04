/*
상속

코틀린의 모든 클래스는 공통의 최상위 클래스인 Any 를 상속한다.
상위 타입을 선언하지 않으면 Any 가 기본 상위 타입이다.

Any 는 java.lang.object 가 아니고, equals(), hashcode(), toString() 외에 다른 멤버를 갖지 않는다.
*/

open class ExampleSuperClass(p: Int) // open 키워드를 통해 명시적으로 부모 클래스로 선언한다.
class ExampleSubClass(p: Int) : ExampleSuperClass(p) // 콜론(:) 을 이용해 클래스 헤더를 선언하면 상속 할 수 있다.


/**** 상속에서의 생성자 *****/

// 클래스에 주요 생성자가 있으면, 주요 생성자의 파라미터를 사용해서 기반 타입을 그 자리에서 초기화 할 수 있다.
//
// Person, Student 클래스가 그 예시다.
open class Person(Name: String, Age: Int){
    init {
        println("Name: $Name")
        println("Age : $Age")
    }
}

class Student(Name: String, Age: Int, School : String, Grade : Int) : Person(Name, Age){
    init {
        println("School: $School")
        println("Grade : $Grade")
    }
}


// 클래스에 주요 생성자가 없으면, 각 보조 생성자에서 super 키워드로 기반 타입을 초기화하거나 그걸 하는 다른 생성자를 호출한다.
//
// OtherPerson, OtherStudent 클래스가 그 예시다.
open class OtherPerson{
    constructor(Name: String, Age: Int){
        println("OtherPerson super to OtherStudent -> Name: $Name , Age: $Age")
    }
}

class OtherStudent : OtherPerson{
    constructor(Name: String, Age: Int, School: String, Grade: Int) : super(Name, Age){
        println("OtherPerson, Using Super -> $School , $Grade")
    }
}

// open : open 어노테이션은 자바의 final 과 반대다.
// open 은 다른 클래스가 이 클래스를 상속할 수 있게 허용한다.
// 기본으로 코틑린의 모든 클래스는 final 이다.(Effective Java 의 Item 17: Design and document for inheritance or else prohibit it 를 따른 것)

/***** 메서드 오버라이딩 *****/
// 코트린은 메서드 오버라이딩을 명시적으로 해야한다.

// 자바와 달리 코틀린에서는 오버라이딩 가능한 멤버에 open 어노테이션을 명시적으로 설정해야 한다.
open class Animal {
    open fun walk() { // open 을 통해 오버라이드 할 수 있게 한다.
        println("Animal can Walk")
    }

    fun NotAni() : Boolean{
        return false
    }
}

// walk()를 오버라이드 할려면 override 어노테이션이 필요하다. 이를 누락하면 실패한다.
// 그리고 Animal 클래스에 walk() 에 open 이 없는 경우 override 를 사용하든 안 하든 하위 클래스에서
// 동일 시그너치를 갖는 메서드를 선언 할 수 있다.
class Dog() : Animal() {
    /*
    final override fun walk()
        -> override 가 붙은 멤버는 그 자체가 open 이며,하위 클래스에서 다시 오버라이딩 하는 것을
           막고 싶다면 final 을 사용해야 한다.
    */
    override fun walk() { //
        println("Dog can Walk.")
    }
}

/***** 프로퍼티 오버라이딩 *****/
// 먼저 프로퍼티는 클래스 멤버 변수들을 말한다.

// 프로퍼티 오버라이딩은 메서드 오버라이딩과 유사하게 동작한다.
// 상위클래스에 선언된 프로퍼티를 하위 클래스에 재선언하려면 override 를 사용해야하며 호환되는 타입을 사용해야 한다.

// 선언한 프로퍼티는 변수의 초기값(initializer)을 가진 프로퍼티나 getter 메서드를 가진 프로퍼티로 오버라이딩 할 수 있다.

// 아래의 ParX 클래스와 SubX 클래스는 프로퍼티 오버라이딩의 예시다.
//
// val 프로퍼티의 값을 프로퍼티 오버라이딩을 통해 값을 재정의 할 수 있다는 것을 보여준다.
open class ParX {
    open val x: Int get() = 10
    open val y: Int = 20
}

class SubX : ParX() {
    override val x: Int = 125
    override var y: Int = 10 // val 프로퍼티를 var 프로퍼티로 재정의 할 수 있다.
}

// 위 처럼 val 프로퍼티를 var 프로퍼티로 재정의 할 수 있지만 반대는 안된다.
// 이유는 var 프로퍼티는 근본적으로 getter 메서드를 선언하는데
// 그것을 var 로 오버라이딩하면 추가로 하위 클래스에서 getter 메소드를 선언하기 때문이다.

/***** 상위 클래스 구현 호출 *****/
// 하위클래스는 super 키워드를 사용해서 상위클래스의 함수와 프로퍼티 접근 구현을 호출 할 수 있다.
// 다시 말해, 부모 클래스의 메서드와 프로퍼티를 super 을 통해 접근 할 수 있다.
open class Foo {
    open fun f() { println("Foo.f() , Foo.x : $x") }
    open val x: Int get() = 1
}
class Bar : Foo() {
    override fun f() { // 이 함수 호출시 Foo 의 f() 도 같이 호출 되는 것을 알 수 있다.
        super.f()
        println("Bar.f() , Bar.x : $x")
    }
    override val x: Int get() = super.x + 1 // super 을 통해 x 의 값을 바꾸었다.(1 에서 2로 바뀜)
}

// 내부 클래스는 super@Outer 와 같이 외부 클래스의 이름을 사용해서 외부 클래스의 상위 클래스에 접근할 수 있다.
class OthBar : Foo() {
    override fun f() {
        println("OthBar.f()")
    }
    override val x: Int get() = 0

    inner class Baz {
        fun g() {
            super@OthBar.f() // Foo 클래스의 f()의 구현
            println(super@OthBar.x) // Foo 의 x의 getter 사용
        }
    }
}

/**** 오버라이딩 규칙 *****/
/*
코틀린의 구현 상속은 다음 규칙에 제한 된다.

특정 클래스가 바로 위의 상속 클래스에서 같은 멤버의 구현을 여러 개 상속 받으면,
반드시 멤버를 오버라이딩 하고 자신의 구현를 제공해야 한다.

만약 어떤 상위타입의 구현을 사용할지 선택하려면 홑화살괄호 안에
상위 타입의 이름을 붙인 super 를 사용한다.

밑에 A, B, C 클래스가 규칙을 따른 예시다.
*/
open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    // 인터페이스 멤버들은 기본적으로 open 이 설정 되있다.
    fun f() { print("B") }
    fun b() { print("b") }
}

class C() : A(), B { // 여기서 인터페이스 B를 상속하게 되는데, 인터페이스는 기본적으로 open 이 설정 되있다.
    // f() 를 재정의 해야 한다.
    override fun f() {
        super<A>.f() // A.f() 호출
        super<B>.f() // B.f() 호출
    }
}

fun main(args: Array<String>){
    val st : Student = Student("손승용", 18, "대덕소프트웨어마이스터고등학교", 2)
    val Ost : OtherStudent = OtherStudent("Kotlin", 3, "JetBrain", 3)

    val dog : Dog = Dog()
    dog.walk()

    val bar : Bar = Bar()
    bar.f()

    val othBar : OthBar = OthBar()

    othBar.f()
    othBar.Baz().g()

    val c : C = C()
    c.f()
}