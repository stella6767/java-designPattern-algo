package kt2.ch4

/**
 * 자바에서는 동일성에 == , 동등성에 equals를 직접 호출
 * Kotiln에서는 동일성에 ===를 사용, 동등성에 == 호출
 * ==를 사용하면 간접적으로 equals 호출
 *
 * || , && , ! 는 자바와 동일
 *
 * in , !in
 * 컬렉션이나 범위에 포함되어 있다. 포함되어 있지 않다.
 *
 */


fun main() {

    val money = JavaMoney(2000L)
    val money2 = JavaMoney(2000L)
    val money3 = JavaMoney(1000L)

    println(money + money2)

    if (money> money3){
        println("Money1 > Money3")
    }

    println(money == money2)
    println(money === money2)

}


