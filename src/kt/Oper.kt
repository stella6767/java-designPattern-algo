package kt

import com.sun.tools.javac.Main
import java.util.*

class Oper

/**
 * 자바와 달리 클래스에 중괄호를 붙이지 않아도 문법 에러X
 *
 * 자바에서는 변수를 선언하면 자동으로 값이 int는 0, String은 null로 초기화 되지만, 코틀린에서는 자동으로 초기화X
 *
 * */


fun main(array: Array<String>){

    val num =10 // 타입추론(읽기 전용 변수)
    val num2 : Int =30 //타입선언 (읽기 전용 변수)
    var num3 : Int = 40 //변수 변환 (변하는 변수)

    // num2 = 100; // val은 읽기 전용이라 불가
    num3 = 10 //var은 변경 가능


    var num4: String? = null //?를 추가하면 null을 대입할 수 있는 변수
    val num5: String //함수안에서는 변수 선언하는 것이 가능(초기화 안해도 됨)


    test()

    println("${ if (num4 != null) "???" 
    else "null임"}")

    println("${num4?.length}") // 자바스크립트의 옵셔널 체이닝 문법괍 비슷하네.
    println("${num4?.length ?: " length를 알 수 없음"}") //엘비스 연산자

    println(joinForm("홍길동", 21))
    println(joinForm(null, 21)?: "가입 내용 누락")

    //?. safe call
    // as? safe cast
    // ? elvis operator

}

// 널 가능 리턴 함수
fun joinForm(name: String?, age:Int):String?{
    val result = if (name != null) "$name 가입 ($age 세)" else null
    return result
}



//var num6:String = null //?가 없는 변수는 null을 대입할 수 없음.
//var num7:String //함수 밖 필드에서는 변수 초기화가 필수.

var check:Boolean = true
val data : String = "hello"
    get() {
        if (check){
            return field
        }else {
            return field.uppercase(Locale.getDefault())
        }
    }


//상수 선언은 const로 한다.
const val finalData : Int = 10


//val로 선언된 변수는 함수밖에 있어도 초기값을 주지 않아도 될 때가 있다. get() 함수를 정의할 때.
val data2:String
    get() {
        return "hello"
    }


/**
 * 변수는 프로퍼티이다. 실제로 변수를 호출하면 변수가 호출되는 것이 아니라 get() 함수가 내부적으로 호출된다. getter를 만들 필요가 없다.
 */


fun test(){

    //val로 만들었다고 해서 변경이 불가능한 것이 아니라 get함수를 이용해서 접근하면 된다.



    println(data)
    check = false
    println(data)


}


//todo 내가 할 거
