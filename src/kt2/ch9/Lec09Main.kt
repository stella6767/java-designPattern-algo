package kt2.ch9

/**
 * 코틀린에서 생성자는 constructor 키워드로 정의됨. 생략가능
 * class body에 아무것도 없다면 생략가능
 * 주생성자에 파라미터가 하나도 없다면 생략 가능
 *
 * 코틀린에서는 필드만 만들면 getter,setter 자동정의됨(프로퍼티).
 * 그리고 public filed처럼 접근.
 *
 * init 블록은 생성자가 호출되는 시점에 호출됨
 *
 * 생성자 오버로딩보다, default paramter 사용권장
 * 어쩔 수 없이 부생성자를 사용할 경우, 부생성자보다 정적 팩토리 메서드 추천
 *
 * 객체의 속성이라면, custom getter, 아니면 함수
 * final은 val
 * custom getter, custom setter에서 무한루프를 막기 위해 field라는 키워드를 사용
 *
 * */

fun main() {

    val person = KotilnPerson()
    person.isAdult


}

class KotilnPerson(
    name: String = "defaultName",
    var age: Int = 1
) {
    operator fun component1(): String {
        return this.name
    }
    operator fun component2(): Int {
        return this.age
    }


    // property에 대한 custom getter을 만들 때, field 키워드를 사용.
    //backing field라 하며, 프로퍼티(getter)가 아닌, 진짜 자기자신을 가리킴
    var name = name
        get() = field.uppercase()
        set(value) {
            field = value.uppercase()
        }

    //위의 커스텀 게터를 직접 정의하는 것보다, 다른 방식으로 프로퍼티를 추가하는 걸 더 추천
    val uppercaseName: String
        get() = this.name.uppercase()





    init {

        if (age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블럭")
    }


//    constructor(name: String): this(name, 1)
//
//    constructor( ): this("default name"){
//        println("부생성자2")
//    }


//    fun isAdult(): Boolean {
//        return age >= 20
//    }


    //custom getter
    val isAdult: Boolean
        get() = this.age >= 20




}
