package kt2.ch3

import kt2.ch1.Person

/**
 * 코틀린에서 타입캐스팅은 모두 명시적으로 이루어져야 한다.
 * 변수가 nullable이라면 적절한 처리필요
 *
 * 코틀린에서는 is, !is, as, as? 를 이용해 타입을 확인하고 캐스팅
 *
 * Any는 자바의 Object 역할
 * Any로 Null도 표함하고 싶으면 Any?
 *
 * Unit은 자바의 void와 비슷
 * void와 다르게 Unit은 그 자체로 타입 인자로 사용가능
 * 실제 존재하는 타입
 *
 * Nothing은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
 * 무조건 예외를 반환하는 함수/ 무한 루프 함수
 *
 */

fun main() {

    val number1 : Int?= 3
    val number2: Long = number1?.toLong() ?: 0L

    printAgeIfPerson(null)
    printAgeIfPerson(Person("kang", 11))

    val person = Person("kang", 100)
    System.out.println(String.format("이름: %s", person.name));

    println("이름 : ${person.name}")


    val str = """
        ABCD
        EFG
        ${person.name}
    """.trimIndent()

    println(str)


    val str2 = "ABC"
    println(str[0])


}


fun fail(msg:String): Nothing{
    throw IllegalArgumentException(msg)
}

fun printAgeIfPerson(obj: Any?){

    val person = obj as? Person

    println(person?.age)


    if (obj !is Person) println()

    if (obj is Person){
//        val person = obj as Person
//        println(person.age)
        //위해서 캐스팅안해줘도 스마트캐스트
        println(obj?.age)
    }

}