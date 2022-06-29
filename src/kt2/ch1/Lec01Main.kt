package kt2.ch1


/**
 * Kotiln에서 Primitive Type
 *
 * 숫자, 문자, 불리언과 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
 * 이 타입들은 클래스(Long) 즉 래퍼런스 타입으로 보이나, 실행시에 원시타입으로 된다.
 * 즉, 개발자가 Boxing, Unboxing을 고려하며 성능 최적화에 신경쓰지 않도록 알아서 해줌.
 *
 */


fun main(){

    //var= 변경가능

    var number1 = 10L //타입추론
    var number3: Long? = 1000L //null 가능
    number3 = null

    val person = Person("강민규") //new 생략가능

}
