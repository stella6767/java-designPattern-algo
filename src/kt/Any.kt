package kt

import java.util.*


/**
 * 코틀린은 모든 자료형이 클래스이다. wrapper로 감싸져 있다고 생각하면 된다.
 * 그렇기 때문에 아래와 같이 선언하여 초기화하면 함수를 바로 사용할 수 있다.
 *
 * 자바에서는 가장 최상위 객체가 Object 인데, 코틀린에서 가장 최상위 객체는 Any이다.
 * 무슨 타이이 들어올지 모를 때는 <T> 제네릭을 선언하거나, Any로 선언하면 된다.
 *
 *
 * 코틀린은 클래스 밖에서 변수를 선언할 수 있기 때문에 전역변수가 가능하므로, 변수 이름이 충돌되는구나.
 *
 *
 *
 */
val data3: Int = 10

//data3.함수()를 바로 사용할 수 있다.


fun parseInt(str: String): Int? {

    //return str.toInt()    // 숫자로 타입 캐스팅하고싶을 때, 문자열 "8" 요런거는 변환이 되지만, "HELLO" 라는 문자열 등은 숫자로 변환이 안 됨. 실제 실행하면 런타임 에러

    return str.toIntOrNull() //요렇게 변경, 정상이 아니면 NULL 반환.
}



fun main() {

    val  a: Any = 1234
    val  a2: Any = "1234"
    var a3: Any = 'c'
    a3 = false

    val b1 = 123
    val b2 = b1 is Int // type check = java instance of
    val b3 = b1 !is Int // type check = java instance of, 조건문에도 쓰임.

    //val c:Byte = b1 as Byte //cast type을  강제 변환, classCastException, type casting
    //바이트를 정수로 강제로 형변환 할 때는,


    val toInt:Byte = b1.toByte() //명시적 형변환 - 더 넓은 범위로 형변환.
    //null을 허용하는 방법
    val data:Int? = null



}