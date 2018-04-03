// 인터페이스(Interface)
//
// 코틀린의 인터페이스는 자바 8 인터페이스와 매우 비슷하다.
// 추상 메서드를 선언할 수 있고 메서드 구현을 포함 할 수 있다.
// 여기서 인터페이스와 추상 메서드의 차이점은 인터페이스는 상태를 가질 수 없다는 것이다.
// 인터페이스가 프로퍼티를 가질 수 있지만 프로퍼티는 추상이거나 접근자 구현을 제공해야 한다.

// 인터페이스는 interface 키워드를 정의한다.
// 클래스와 오브젝트는 한개 이상의 인터페이스를 구현 할 수 있다.
interface MyInterface{
    /*
     인터페이스에 프로퍼티를 선언할 수 있다.
     인터페이스에 선언한 프로퍼티는 추상이거나 또는 접근자를 위한 구현을 제공할 수 있다.
     인터페이스의 프로퍼티는 지원(backing) 필드를 가질 수 없으므로,
     인터페이스에 선언한 프로퍼티에서 지원 필드를 참조할 수 없다.

     (지원 필드는 별도의 get/set 메소드를 생성하는 것이 아닌 선언과 동시에 값을 validation 하고, 이에 따른 결과를 처리하는 필드이다.)
    */

    val prop: Int // 추상
    val propertyWithImplementation: String
        get() = "foo"
    fun bar() // 추상
    fun foo(){
        print(prop)
    }
}

class Child : MyInterface{
    override fun bar() {
        println("Hello")
    }
    override val prop: Int = 29
}

/***** 인터페이스 오버라이딩 충돌 해결 *****/
/*
인터페이스 A와 B 둘다 foo() 와 bar() 함수를 선언하고 있다.
둘 다 foo() 를 구현하고 있고 bar()는 B만 구현하고 있다.

여기서 A의 bar() 에 abstract 를 붙이지 않은 이유는
인터페이스의 메서드는 몸체가 없으면 자동으로 추상화 되기 때문이다.
*/

interface A{
    fun foo(){ print("A")}
    fun bar()
}

interface B{
    fun foo(){ print("B")}
    fun bar(){ print("bar")}
}

class C: A{ // A를 상속받은 C는 bar() 를 오버라이딩해서 구현을 제공해야한다.
    override fun bar(){ print("bar")}
}

/*
A와 B를 상속받은 D는 두 인터페이스에서 상속한 모든 메서드를 구현해야하고
D가 어떻게 메서드를 구현할지 지정해야 한다.

이는 구현을 상속한 메서드 bar()과 여려 구현을 상속한 foo()애 모두 적용된다.
*/
class D: A, B{
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar(){
        super<B>.bar()
    }
}

fun main(args: Array<String>){
    val d = D()
    d.foo()
    d.bar()
}