package kt2.ch18

import kt2.ch1.Person
import kt2.ch11.number
import kt2.ch17.Fruit
import kt2.ch9.KotilnPerson
import kt2.ch17.sameNameFunc as ch17sameNameFunc

/**
 * 코틀린의 이모저모
 *
 * 1. Type Alias와 as import
 * 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶다면.. 자바에서는 패키지 이름을 다 명시하는 방법이지만
 *
 * 2. 구조분해와 componentN 함수
 * 코틀린에서도 구조분해할당 문법이 가능한데, data class는 기본적으로 구현이 되어있고
 * 다만 구조분해는 인자의 순서대로 갖고오므로, 필드의 이름까지 파악하지 않는다.
 * 그냥 class에도 적용하고 싶으면, operator fun component1, n2, n3 ......
 *
 * 3. Jump와 Label
 * return: 기본적으로 가장 가까운 function or 익명함수로 값이 반환
 * break: 가장 가까운 루프 제거
 * continue: 가장 가까운 루프를 다음 step으로 보냄
 *
 *  Label을 사용한 jump는 가급적 사용하지 않는 것을 추천
 *
 * 4. Takeif와 TakeUnless
 *
 *
 */


data class Example(
    val name: String,
    val age: Int
)


fun main() {

    ch17sameNameFunc()
    sameNameFunc()


    val example = Example("kang", 100)
    val exampleName = example.component1()

    val person = KotilnPerson("kang", 29)
    val (age, name) = person

    println("${age}  ${name}")

    val numbers = listOf(1, 2, 3)

    numbers.map { num -> num + 1 }
        .forEach { num ->
            //if (num == 3) continue or break  불가!
            println(num)
        }


    /**
     * 만약
     * 하고 싶으면..
     */

    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@run //break run 블록에 감싼 후
                //return@forEach =  continue
            }
            println(number)
        }
    }


    for (number in numbers) {
        if (number == 3) continue
        println(number)
    }


    /**
     * break@라벨을 하면, break가 label에 붙인 for문을 멈춰버린다.
     */

    loop@ for (i in 1..100){
        for (j in 1..100){
            if (j == 2){
                break@loop
            }
            println("${i} ${j}")
        }
    }



}

fun sameNameFunc() {

}

typealias CompleteFilter = (Fruit, Long, Int, String) -> Boolean

fun filterSomething(fruit: Fruit, completeFilter: CompleteFilter) {

}

data class CompleteSuperHybridSomethingDataClass(
    val name: String,
    val price: Int
)

typealias CSSDC = Map<String, CompleteSuperHybridSomethingDataClass>


fun getNumberOrNull():Int? {
    return if (number <= 0){
        null
    }else{
        number
    }
}


fun getNumberOrNull2():Int? {
    return number.takeIf { it > 0 } //주어진 조건을 만족하면 그 값이, 아니면 null
}

fun getNumberOrNull3():Int? {
    return number.takeUnless { it <= 0 } //주어진 조건을 만족하지 않으면 그 값이, 아니면 null
}

