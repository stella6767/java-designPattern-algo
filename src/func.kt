/**
 * 함수 문법
 *
 * 반환타입이 없으면 Unit, 반환타입이 있으면, Int, String 같은 타입들을 적어주고 return
 */

fun play(num:Int): Unit {
    println("num : ${num}")
}

fun add(n1:Int, n2:Int):Int{
    return n1+n2
}



fun add2(n1:Int, n2:Int):Int{

//    fun change(): Unit{
//        n1 = n1 + 30
//    }
    //return n1+n2

    /**
     * 함수 안에 함수를 선언할떄,
     * 문법오류가 나는 것은, 함수 파라메터가 디펄트로 val(읽기전용)로 잡히기 때문
     * 함수안에 매개변수는 val, var을 선언할 수 없다. 무적권 val로 자동선언
     */

    fun change(): Int{
        return n1 + 30;
    }
    return change()+n2
}


fun add3(n1:Int, n2:Int):Int{

    val change = {n1 + 30}

    /**
     * 람다로 변경
     * 흠. 코틀린에서는 자바스크립트처럼 변수에 함수를 할당시켜줄 수 있나보네.
     * function을 일급객체로 활용가능? 자바8의 메서드 래퍼런스 같은 건가, function interface 처럼
     */

    return change()+n2
}


/**
 * 명명된 인수 사용
 */
fun printN1(n1: Int = 10) : Unit{
    println(n1)
}


fun main() {
    play(10)
    println(add3(50,60))

    printN1() //매개변수가 1일 떄 변수를 명시할 필요는 없음.
    printN1(30) //오버로딩
    printN1(n1 = 20) //명명된 인수


}




