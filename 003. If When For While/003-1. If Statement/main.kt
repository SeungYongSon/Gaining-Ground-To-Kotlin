/*
If 식

코틀린에서 if 는 식으로 값을 리런한다. 그래서 삼항 연산자가 없다.
일반 if 로 동일하게 할 수 있기 때문이다.
 */

fun main(args : Array<String>){
    val a : Int = 10
    val b : Int = 5
    var max = a

    // 전통적인 용법
    if(a < b) max = b

    // else 사용
    var elMax: Int
    if(a > b){
        elMax = a
    } else {
        elMax = b
    }

    // 식으로
    val exMax = if(a > b) a else b

    // if 브렌치는 블록일 수 있으며 마지막 식이 블록이 값이 된다.
    val bmax = if(a > b){
        print("Choose a")
        a
    } else{
        print("Choose b")
        b
    } // 문장이 아닌 식으로 if 를 사용하면(식의 값을 리턴하거나 변수에 값을 할당할 때), else 브렌치를 가져야 한다.
}