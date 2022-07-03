package kt2.ch14


/**
 *  Named paramter를 활용하면, builder pattern을 쓰는 것 같은 효과까지
 *
 *  enum은 when을 조합해서 쓸 시 더 강력함.
 *  else 구문을 따로 작성해줄 필요없으며, 만약 when return 할시 enum case가 명시되지
 *  않았다면 컴파일러가 에러 감지.
 *
 *
 * sealed class의 하위 클래스는 같은 패키지에 있어야 한다.
 * 따라서 외부에서는 이 클래스를 상속받을 수 없다. 라이브러리로 제공할 때, 외부에서
 * 상속을 못 하도록 막을 경우 유용하게 쓸 수 있겠다. 하위 클래스 봉인
 * sealed class의 경우 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
 * 즉, 런타임 때 클래스 타입이 추가될 수 없다. 따라서 안심하고 when으로 enum 같은
 * 효과를 누릴 수 있다. else 구문을 안 만들어도 안심
 *
 */

fun main() {
    val dto1 = KotilnPersonDto("강민규", 29)
    val dto3 = KotilnPersonDto(name = "전성호")


    println(dto1)
}


data class KotilnPersonDto(
    val name: String,
    val age: Int = 0
) {

}


enum class KotilnCountry(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US")
}


fun handleCountry(country: KotilnCountry){
    return when(country){
        KotilnCountry.KOREA -> TODO()
        KotilnCountry.AMERICA -> TODO()
    }
}


sealed class HyundaiCar(
    val name: String,
    val price:Long
)


class Avante : HyundaiCar("아반떼", 1000L)
class Sonata : HyundaiCar("sonata", 2000L)
class Grandeur : HyundaiCar("grandeur", 3000L)



fun handleCar(car: HyundaiCar){
    when(car){
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}