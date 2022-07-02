package kt2.ch16

import kt2.ch1.Person

/**
 * 1. 확장함수
 * fun 확장하려는클래스.함수이름(파라미터):리턴타입 {
 *        // this를 이용해 실제 클래스 안의 값에 접근
 * }
 * C#의 extension 기능을 갖다 쓴 건가? 암튼 내가 통제할 수 없는 외부 클래스를 커스텀
 * 할때 유용하게 쓸 수 있겠군
 * 그렇다고 하더라도 수신객체 내의 private 또는 protected 맴버를 가져올 순 없다.
 * 맴버함수와 확장함수의 시그니처가 같으면 맴버함수가 우선권을 가지게 된다.
 * 따라서 이 부분은 주의
 * 확장함수가 오버라이드 되면 해당 변수의 현재 타입에 따라 결정
 * java에서 kotiln 확장함수는 정적메서드를 부르는 것처럼 사용가능
 *
 * 중위함수(infix 함수)
 * 변수.함수이름(argument) 대신 변수 함수이름 argument
 * 맴버함수에도 가능
 * example) downTo , step
 *
 *
 * inline 함수
 * 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하는 경우
 * 함수를 파라미터로 전달할 때에 오버헤드를 줄이는 용도 ( 성능 최적화)
 *
 *
 * 지역함수
 * 함수 안에 함수를 선언가능
 * 코드가 더러워 보이므로 가급적 쓰지말자..
 */


fun main() {
    val str: String = "ABC"
    str.lastChar() // 원래 String에 있는 맴버함수처럼 사용가능


    val train: Train = Train()
    train.isExpensive()//Train의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive() // Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive() // Srt의 확장함수

    3.add2(4)
    3 add2 4  // 중위함수

    3.add3(4)

}

//
inline fun Int.add3(other:Int): Int {
    return this + other
}

//확장함수 + 중위
infix fun Int.add2(other:Int): Int {
    return this + other
}


// String 클래스를 확장,
fun String.lastChar(): Char {
    return this[this.length - 1]
}

//확장 프로퍼티
val String.lastChar : Char
    get() = this[this.length - 1]


open class Train(
    val name: String = "새마을기차",
    val price: Int = 5000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10000
}




fun createPerson(firstName: String, lastName:String):Person {

//    if (firstName.isEmpty()){
//        throw IllegalArgumentException("firstName은 비어있을 수 없습니다. 현재 값: ${firstName}")
//    }
//
//    if (lastName.isEmpty()){
//        throw IllegalArgumentException("firstName은 비어있을 수 없습니다. 현재 값: ${lastName}")
//    }

    fun validataName(name: String, fieldName: String){
        if (name.isEmpty() ){
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다!")
        }
    }

    /**
     * 요런 식으로 지역함수를 통해, 중복코드를 줄일 수 있다..
     */

    validataName(firstName, "firstName")
    validataName(lastName, "lastName")

    return Person(firstName,lastName, 1)
}