package kt2.ch17

import java.util.*

/**
 * 코를린에서 함수는 그 자체로 값
 * 1급 시민의 조건을 다 갖추고 있음.
 * 변수에 할당가능
 * 인자로 넘기기 가능
 * 리턴값으로 가능
 *
 * 마지막 파라미터가 함수인 경우, 소괄호 빡에 람다사용가능
 * 람다를 작성할 때, 람다의 파라미터를 it으로 직접 참조
 * 람다를 여러 줄 작성할 수 있거, 마지막 줄의 결과가 람다의 반환값 (여러 줄이어도 return 생략가능)
 *
 * 람다는 중괄호 방법이 많이 사용됨.
 *
 */


fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1000),
        Fruit("사과", 1000),
        Fruit("사과", 1000),
        Fruit("바나나", 1200),
        Fruit("바나나", 1200),
        Fruit("바나나", 1200),
        Fruit("수박", 3000)
    )

    //소괄호 밖으로 중괄호를 뺄 수 있음. 그러면 마지막 파라미터로 넘어감.
    filterFruits(fruits) { fruit -> fruit.name == "사과" }

    var targetFruitName = "바나나"
    targetFruitName = "수박"
    //자바에서는 effectively final 이라해서 자동으로 컴파일러가 람다에서 쓰는 거면
    // final로 만들어지므로 위의 과정이 불가능했지만 코틀린은 보다시피 가능.
    //코틀린은 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고
    // 있음. 이러한 데이터 구조를 클로저라 부름
    filterFruits(fruits) { it.name == targetFruitName } //it으로 또 생략가능
}


private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit>{
    val result = mutableListOf<Fruit>()
    for (fruit in result) {
        if (filter(fruit)){
            result.add(fruit)
        }
    }
    return result
}


private fun filterFruits2(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit>{

    //mapwithIndex도 지원
    //all: 조건을 모두 만족하면 true, 아니면 false
    //none: all의 반대
    //any: 조건을 하나라도 만족하면 true
    //first, last .. 첫번째 값 , 마지막 값을 가져온다. 무조건 null이 아니어야 함
    //firstOrNull, lastOrNull
    //groupby, associateBy =  List to Map
    //val isAllApple = fruits.all({ fruit -> fruit.name == "사과" })


    return fruits.filter(filter)
}



//val isApple: (Fruit)->Boolean = fun (fruit:Fruit):Boolean {
//    return fruit.name == "사과"
//}
//val isApple2 = { fruit: Fruit -> fruit.name == "사과" }
