// 프로퍼티
//
// 코틀린에서 클래스는 프로퍼티를 가질 수 있다.
// var 키워드로 변경 가능하게 선언하거나 val 키워드로 읽기 전용으로 선언할 수 있다.
class Address{
    var name : String = "ssy"
    var where : String = "dsm"
    var city : String = "dj"
}

// Java 필드처럼 이름으로 프로퍼티를 참조할 수 있다.
fun copyAddress(address: Address) : Address{
    val result = Address()
    result.name = address.name
    result.where = address.where
    result.city = address.city
    return result
}


/****** Kotlin 프로퍼티의 Getters 와 Setters *******/
class Custom{
    /*
    프로퍼티 선언의 전체 구문은 아래와 같다.

    var <propertyName>[: <PropertyType>] [= <Property_initializer>]
        [<getter>]
        [<setter>]

    여기서 initializer, getter, setter 는 선택사항이다.
    initializer 의 리턴 타입에서 유추할 수 있으면 생략가능하다.
    */

    //var allByDefault: Int?
    // 위에코드는 에러! initializer 필요, 기본 getter 와 setter 적용
    var initialized = 1 // Int 타입을 갖고, 기본 getter 와 setter 적용

    // 읽기 전용 프로퍼티 선언은 변경가능 프로퍼티 선언과 두 가지가 다르다.
    // var 대신 val 로 시작하여 setter 를 허용하지 않는다.

    // val simple: Int?
    // 위에 코드는 에러다. Int 타입이고, 기본 getter, 생성자에서 초기화해야 함
    val inferredType = 1 // Int 타입이고, 기본 getter

    val size : Int = 0
    val isEmpty: Boolean
        get() = this.size == 0 // size 가 0 이면 true 반환 아니면 false 반환

    var stringRetention: String
        get() = this.toString()
        set(value){
            println("value: $value")
        }

    // 코틀린 1.1 부터, getter 에서 타입을 추론할 수 있으면 프로퍼티 타입을 생략할 수 있다.
    val anothIsEmpty get() = this.size == 0 // Boolean 타입임
}

/***** 지원(Backing) 필드 *****/
class BackingField{
    // 코틀린 클래스는 필드를 가질 수 없다. 하지만 때때로 커스텀 접근자를 사용할 때 지원 필드가 필요 할 때가 있다.
    // 그래서 코틀린은 field 식별자로 접근 할 수 있는 지원 필드를 자동으로 제공한다.
    var counter = 0
        set(value) {
            if(value >= 0){
                field = value
                println("Using field")
            }
        }
    // 여기서 field 식별자는 오직 프로퍼티의 접근자에서만 사용 할 수 있다.
    // 접근자의 기본 구현을 적어도 한 개 이상 사용하거나 또는 커스텀 접근자에서 field 식별자로 지원 필드에 접근 할 경우,
    // 프로퍼티를 위한 지원 필드를 생성한다.
}

/***** 지원(Backing) 프로퍼티 *****/
// "자동 지원 필드" 방식이 맞지 않을 때 지원(backing) 프로퍼티로 대신 할 수 있다.
class BackingProperty{
    private var _table: Map<String, Int>? = null
    val table: Map<String, Int>
            get(){
                if(_table == null){
                    _table = HashMap()
                }
                return _table ?: throw AssertionError("Set to null by another thread")
            }
    // 모든 면에서, 이는 자바와 같다. 기본 getter 와 setter 를 가진 private 프로퍼티에 접근하면
    // 함수 호출에 따른 오버헤드가 발생하지 않도록 최적화하기 때문이다
}

/***** 컴파일 타임 상수 *****/
/*
컴파일 시점에 알아야 할 프로퍼티 값을 const 수식어를 이용해서 _컴파일 타임 상수_로 표시 할 수 있다.
그런 프로퍼티는 아래 조건을 충족해야 한다
- 최상위 또는 오브젝트의 멤버
- String 이나 기본 타입 값으로 초기화
- 커스텀 getter 가 아님
*/

// 이 프로퍼티는 애노테이션에서 사용 할 수 있다.
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo(){}

fun main(args: Array<String>){
    val address = Address()
    val copyAddress = copyAddress(address)
    println("copyAddress : " + copyAddress.name + " " + copyAddress.where + " " + copyAddress.city)

    val custom = Custom()
    custom.stringRetention = "set() is running" // set()
    println(custom.stringRetention) // get()

    println(custom.isEmpty)
    println(custom.anothIsEmpty)

    val backingField = BackingField()
    backingField.counter = 10

    val backingProperty = BackingProperty()
    backingProperty.table

    println(SUBSYSTEM_DEPRECATED)
}