/*
추상화

클래스나 클래스의 멤버를 abstract 로 선언할 수 있다.
추상 멤버는 그 클래스에 구현을 갖지 않는다.
추상 클래스나 함수에 open 을 붙일 필요는 없다.
*/

open class Animal(var Name : String)

abstract class IsWalk(Name: String) : Animal(Name) {
    abstract fun Walk()
}

class Dog(Name: String) : IsWalk(Name){
    override fun Walk() {
        println("$Name can walk.")
    }
}

fun main(args: Array<String>){
    val dog : Dog = Dog("Shiba")
    dog.Walk()
}