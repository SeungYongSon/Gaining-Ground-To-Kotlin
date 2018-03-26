/***** 초기화 지연(Late-Initialized) 프로퍼티 ****/
/*
먼저 초기화 지연을 하면 무엇이 좋은 걸까?
좋은점은 소프트웨어의 성능 측면에서 이점이 있다.

클래스가 초기화될 때 모든 것들을 동시에 초기화하는 코드와
필요한 순간까지 초기화를 최대한 미루는 코드 중에
어떤 것이 성능 측면에서 좋을지 생각해보면 답은 쉽게 나온다.
결국 소프트웨어의 실행시간 및 메모리 효율을 개선 할 수 있다.

초기화 지연(Late-Initialized) 프로퍼티는 프로퍼티의 초기화를 나중에 하기 위해 사용하는 키워드 이다.
프로퍼티 선언에 사용되며 항상 사용 가능한 것은 아니다. 아래 사용하기에 제약사항을 보자.

- var(mutable) 프로퍼티만 사용 가능
- non-null 프로퍼티만 사용 가능
- 커스텀 getter/setter가 없는 프로퍼티만 사용 가능
- primitive type 프로퍼티는 사용 불가능
- 클래스 생성자에서 사용 불가능
- 로컬 변수로 사용 불가능

이렇게 제약사항이 많은데 왜 사용하는 걸까?
그 이유는 Kotlin 은 Non-null, Nullable 에 대해 검사가 엄격하기 때문이다.
만약 Non-null 로 선언한 프로퍼티를 선언과 동시에 초기화를 하지 않으면 컴파일 에러가 난다.
하지만 보통 우리는 멤버 변수가 클래스 초기화와 동시에 함께 초기화 되지 않길 원하는 경우가 많다.
그래서 이런 점에서 불편한 점을 느낄 수 있다.

이 경우를 위해 lateinit 수식어를 붙인다.
 */
class LateInitTest{
    private lateinit var name: String // lateinit 수식어를 붙여 선언과 동시에 초기화를 안해도 된다.
}
/*
lateinit 는 언제 사용하면 좋을까?

lateinit은 이 프로퍼티는 절대로 Null이 될 수 없는 프로퍼티인데
초기화를 선언과 동시에 해줄 수 없거나 성능이나 기타 다른 조건들로 인해
최대한 초기화를 미뤄야 할 때 사용 하면 좋을 것이다.

밑에는 안드로이드에서 lateinit 를 사용하여 mWelcomeTextView 을 Non-null 프로퍼티로 선언하지 않고
onCreate()에서 초기화 시키는 예시이다.

이는 lateinit 을 사용하면 Non-null 으로 선언할 필요도 없고 선언과 동시에 초기화을 안해도 되기 때문에
효율적으로 코드를 짤 수 있다.

class MainActivity : AppCompatActivity() {
    private lateinit var mWelcomeTextView: TextView // lateint 이용함. 선언과 동시에 초기화 필요 없음
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWelcomeTextView = findViewById(R.id.textView) as TextView // 초기화 시킴
    }
}

*/


