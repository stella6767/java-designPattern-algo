package kt2.ch5

/**
 * 함수에서 Unit(void) 생략가능
 * Exception을 던질 때 new 생략가능
 *
 * 자바에서는 if-else는 Statement이지만 코틀린에서는 Expression(하나의 값으로 도출)
 * 따라서 코틀린에서는 삼항연산자가 필요하지 않으므로 없음.
 *
 * in  / 마치 between 연산자
 *
 * 코틀린에서는 switch case 대신 when을 사용
 * when 문법은 Enum Class 혹은 Sealed Class 와 함께 사용할 경우, 더욱더 진가
 */


fun validateScoreIsNotNegative(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}의 범위는 0부터 100입니다.")
    }
}


fun getPassOrFail(score: Int): String {

    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else {
        "C"
    }
}

fun getGradeWithSwith(score: Int): String {

    return when (score / 10) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        7 -> "C"
        else -> "D"
    }

}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다")
        else -> println("1, 0, -1 이 아닙니다. ")
    }
}

fun judgeNumber2(number: Int) {
    when  {
        number == 0 ->  println("주어진 숫자는 0")
        else -> println("0 외 나머지")
    }
}




