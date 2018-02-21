/***** 디폴트 임포트 *****/
/*

기본적으로 코틀린 파일은 여러 패키지들을 임포트하게 된다.

그 목록은 아래와 같다.
    kotlin.*
    kotlin.annotation.*
    kotlin.collections.*
    kotlin.comparisons.* (since 1.1)
    kotlin.io.*
    kotlin.ranges.*
    kotlin.sequences.*
    kotlin.text.*

코틀린이 동작하는 환경에 따라 추가적으로 아래 패키지를 더 추가한다.
-JVM
    java.lang.*
    kotlin.jvm.*

-JS
    kotlin.js.*

*/



/***** 임포트 *****/
/*
디폴트 임포트에 추가로 각 파일은 자신이 원하는 패키지를 가져올 수 있다.
import 에 대한 문법은 Kotlin Grammar Document(http://kotlinlang.org/docs/reference/grammar.html#import)를 보자.
*/

import foo.Bar // 접근하고자 하는 패키지명을 직접 적용한다.
import foo.* // 와일드카드로(*) 'foo' 의 모든 패키지, 클래스, 객체 등을 접근할 수 있게 처리할 수 있다.


// 만약 foo.Bar 과 bar.Bar 처럼 겹치는 패키지명이 겹치는 경우
import bar.Bar as bBar // as 키워드로 충동하는 대상에 다른 이름을 부여해서 겹침을 없앨 수 있다.

/*
import 키워드는 클래스뿐만 아니라 다른 곳에 선언된 것을 가져 올 수 있다.

가져 올 수 있는 것은 다음 밑에와 같다.

최상위 함수 및 속성
object로 선언된 함수 및 속성값
열거형 상수들


코틑린은 자바와 달리 "import static" 구문이 없고 import 키워드로 모든 선언을 임포트 할 수 있다.
*/



/***** 최상위 선언의 가시성 *****/
// 민약 최상위 선언이 private 이면, 선언된 파일에 대해 private 가 적용된다.