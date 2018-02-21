/*
문자열

코틀린에서 문자열은 String 타입으로 표현하고 불변(immutable)이다.

*/

fun main(args: Array<String>){

    // 문자열의 요소는 문자로서 s[i] 와 같은 인덱스 연산으로 접근 할 수 있다.
    val s : String = "ASDFISGOD"
    println(s[4])

    //for -루프로 문자열을 순회 할 수 있다.
    for(c in s){
        println(c)
    }


    /***** 코틀린에서의 문자열 리터럴 *****/

    /*
        코틀린은 두 가지 타입의 문자열 리터럴을 지원한다.

        하나는 escaped 문자열로 탈출 문자를 가질 수 있다.
        (escaped 문자열은 자바 문자열과 거의 같다,)

        다른 하나는 raw 문자열로 뉴라인과 임의 텍스트를 가질 수 있다.

    */

    //escaped 문자열
    val eS : String = "Hello, World!\n"

    //raw 문자열 - 세 개의 따옴표로 구분한다.
    val rS : String = """
            for(c in "KOTILN")
                print(c)
    """ // 특수 문자를 포함하지 않고 뉴라인과 모든 다른 문자를 포함 할 수 있다.


    // 더 나아가 trimMargin() 함수를 사용해서 앞쪽 공백을 제거 할 수 있다.
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin() // | 문자를 사용하여 기본 여백의 접두사를 표기하지만 다른 문자를 선택하여 매개 변수로 전달할 수 있다.




    /***** 문자열 템플릿 *****/

    // 문자열은 템플릿 식을 포함 할 수 있다
    // 템플릿 식은 달러 부호($)로 시작하고 간단한 이름으로 구성된다.
    val i = 10
    val tS : String = "i = $i" // "i = 10"로 평가.

    // 아니면 중괄호 안에 임의의 식을 넣을 수 있다.
    val abc : String = "abc"
    val tSA : String = "$abc.length is ${abc.length}" // "abc.length is 3"으로 평가.

    // raw 문자열과 escaped 문자열에도 템플릿 식을 넣을 수 있다.

    // raw 문자열에세 $ 문자를 표현하고 싶다면 다음구문을 사용하면 된다.
    val price = """
        ${'$'}9.99
    """
}