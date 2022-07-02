package kt2.ch15

/**
 *  우선은 불변리스트로 만들고 필요한 경우 가변으로 바꾸자

 * List<Int?> // 리스트에 null이 들어올 수 있음. 리스트는 절대 null이 아님
 * List<Int>? // 리스트에 null value 불가, 리스트는 null 가능
 * List<Int?>? // 리스트에 null value가 들어올 수 있고, 리스트가 null일 수도 있음
 *
 * Java는 읽기전용 컬렉션과 변경가능 컬렉션을 구분하지 않는다.
 * java는 nullable 타입과 non-nullable 타입을 구분하지 않는다.
 * 따라서 코틀린 쪽 컬렉션을 자바에서 불러오면 오작동을 일으킬 수 있으므로,
 * 방어코드를 작성하거나, 코틀린 쪽에서도 Collections.unmodifableXXX()를 활용하면
 * 변경자체를 막을 수 있음.
 *
 */

fun main() {

    val array = arrayOf(100, 200)
    array.plus(300)

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    for ((idx, value ) in array.withIndex()){
        println("${idx} ${value}")
    }


    val numbers = listOf(100, 200) //기본은 불변리스트
    val emptyList = emptyList<Int>() //타입추론을 못하므로 타입을 명시
    useNumbers(emptyList()) // 타입추론이 가능하므로 생략

    numbers.get(0)
    numbers[0]

    for (number in numbers) {
        println(number)
    }

    for ((index,value ) in numbers.withIndex()) {
        println(value)
    }


    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300) //기본 구현체는 arraylist이고 사용법은 동일

    val numbersSet = setOf(100,200)

    val oldMap = mutableMapOf<Int,String>()
    oldMap.put(1, "MONDAAY") //방법 1
    oldMap[2] = "TUESDAY" //방법 2

    val immuatableMap = mapOf(1 to "MONDAY", 2 to "TUESDAY") // 중위호출

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for (entry in oldMap.entries) {
        println(entry.key)
        println(entry.value)
    }




}


private fun useNumbers(numbers: List<Int>){

}

