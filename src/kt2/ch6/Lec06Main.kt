package kt2.ch6

/**
 * 코틀린에서 For문은 등차수열을 사용
 * For each문에서 자바는 : , 코틀린은 in을 사용
 * 전통적인 for문에서 Kotiln은 등차수열과 in을 사용
 *
 * while은 do - while 까지 다 자바와 같음
 */


fun main() {
    for (i in 1..3){
        println(i)
    }
    for (i in 3 downTo 1){
        println(i)
    }
    for (i in 1..5 step 2){
        println(i)
    }

    var i = 1

    while (i <= 3) {
        println(i)
        i++
    }
}