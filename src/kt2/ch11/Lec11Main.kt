package kt2.ch11


/**
 * 코틀린은 접근제어자는
 * public, (자바와 동일)
 * protected, (선언된 클래스 또는 하위 클래스에서만 접근가능)
 * internal,
 * private (자바와 동일)
 *
 * default는 사라지고 대신 같은 모듈에서만 접근 가능한 internal 키워드가 생겼다.
 * kotiln의 기본 접근 지시어는 자바와 다르게 public이다.
 *
 * 자바와 다르게 모든 코드가 클래스 소속임을 강제하는 문법이 아니고,
 * 하나의 파일안에 변수, 함수, 클래스 여러개를 만들 수 있다.
 * 또한 함수가 이제는 1급 시민이다.
 *
 * kotiln에서 class가 public이 아닌 접근 지시어를 붙이려면 constructor를 명시해줘야 한다.
 *
 * Internal은 바이트 코드 상 public이 된다.
 * 때문에 자바코드에서는 kotiln 모듈의 internal 코드를 가져올 수 있다.
 * 같은 모듈이란. 한꺼번에 컴파일되는 코틀린 파일들을 의미
 *
 *
 */


public val number: Int = 10 //어디서든 접근가능
private val number2: Int = 11 // 같은 파일 내에서만 접근
internal val number3: Int = 12 //같은 모듈에서만 접근
// protected val number3:Int = 13 // 파일 최상단에는 사용불가


open class Cat protected constructor(

)


class Car(
    internal val name: String,
    _price: Int
) {

    /**
     * 생성자에서 getter setter 한 번에 접근지시자 설정하는 방법과
     * 아래처럼 setter에만 추가적으로, 가시성을 정의할 수 있음.
     */

    var price = _price
        private set

}


fun main() {

    isDirectoryPath("")


}