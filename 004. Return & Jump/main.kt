/*
리턴과 점프

코틀린에는 세 가지 구조의 점프 식이 있다.
- return : 기본으로 가장 가깝게 둘러싼 함수나 익명 함수 에서 리턴한다.
- break : 가장 가깝게 둘러싼 루프를 끝낸다.
- continue : 가장 가깝게 둘러싼 루프의 다음 단계를 진행한다.

세 식 모두 더 큰 식의 일부로 사용 할 수 있다.

예시 코드다.
val s = person.name ?: return // 이 세 식의 타입은 Nothing 이다.
*/

fun main(args: Array<String>) {

    /***** break 와 continue 라벧 *****/

    // 코틀린의 모든 식에 label 을 붙일 수 있다.
    // 라벨은 @ 부호 뒤에 식별자가 붙는 형식으로,
    // 예를 들어 abc@ , fooBar@ 는 유효한 라벨이다.

    // 이제 label 을 통해서 break 와 continue 를 사용해 보자.

    // 밑에 코드 처럼 label 로 한정시킨 break 는 해당 label 이 붙은 for 루프 이후로 점프시킨다.
    loop@ for(i in 1..100){
        for(j in 1..100){
            if(i > 90 && j > 90){
                println("i = $i , j = $j")
                break@loop
            }
        }
    }
    // continue 는 루프의 다음 반복을 진행한다.

}

/***** 라벨에 리턴하기 *****/
/*
코틀린은 함수 리터럴, 로컬 함수, 오브젝트 식에서 함수를 중첩할 수 있는데
한정한 return 을 사용하면 바깥 함수로부터 리턴 할 수 있다.
가장 중요한 용도는 람다 식에서 리턴하는 것이다.

// return -식은 가장 가깝게 둘러싼 함수에서 리턴한다.
fun foo(){
    ints.foreach {
       if(it == 0) return
        print(it)
    }
}

// 람다 식에서 리턴하고 싶다면 람다 식에 라벨을 붙여 return 을 한정해야 한다.
fun foo() {
    ints.foreach lit@ {
        if(it == 0) return@lit
        print(it)
    }
}

// 암묵적으로 제공하는 라벨을 사용하는 게 편할 때가 있다.
// 이런 라벨을 람다를 전달할 함수와 같은 이름을 갖는다.
fun foo() {
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
    }
}

// 람다 식 대신 익명 함수를 사용해도 된다. 익명 함수에서 return 문장은 익명 함수 자체에서 리턴한다.
fun foo() {
    ints.forEach(fun(value: Int) {
        if (value == 0) return // 익명 함수 호출에 대한 로컬 리턴. forEach 루프로 리턴
        print(value)
    })
}

//만약 특정 값을 반환하는 경우, parser는 정규화된 값을 반환한다.
return@a 1
// 이 코드는 "라벨 @a 에 1 을 리턴"하는 것을 의미한다. "라벨을 붙인 식 (@a 1) 을 리턴" 하는 것이 아니다.
*/