package kt2.ch2

import kt2.ch1.Person

/**
 * Null을 다루는 방법
 *
 * Null이 아닌 경우만 호출 Safe Call / ?.
 * null인 경우만 호출 Elvis 연산자 / ?:
 * null이 아니라 단언할 경우 / !!
 * 자바코드를 호출할 때 플랫폼 타입 사용에 유의
 */


fun main() {

    val str: String? = "ABC"
    println(str?.length)
    println(str?.length ?: 0)

    val person = Person(null)
    //startWithA2(person.name)
    println(person.name)

}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null not accept")
}


fun startWithA2(str: String): Boolean? {
    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun calculate(num:Long):Long{
    num ?: return 0
    return 1
}


fun startsWith(str: String?):Boolean{

    //정말 Null이 안 들어올 거라는 확신이 있으면, !! 로 단언할 수 있다.
    //만약 Null 이 들어오면 런타임에러
    return str!!.startsWith("A")
}