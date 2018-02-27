/*
While 루프

코틀린과 다른 언어와 마찬가지로 while 과 do .. while 문은 서로 같다.
*/

fun main(args: Array<String>) {
    var x : Int = 10
    // 예시다.
    while(x > 0){
        x--
    }

    do{
        val y = retrivedData()
    } while (y != null)
}

fun retrivedData(): String {
    return "리턴값"
}