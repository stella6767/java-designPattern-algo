package kt2.ch12


/**
 * static 대신 companion object를 사용. 클래스와 동행하는 유일한 오브젝트
 * companion object도 하나의 객체로 간주, 이름도 붙일 수 있고, 인터페이스도 구현가능
 *
 * const val 는 컴파일 시간에 결정되는 상수이다. (static)
 * const 로 선언을 하면 클래스의 프로퍼티나 지역변수로 할당 할 수 없게 된다.
 * 일반적으로 companion object 안에 상수로 선언하게 된다.
 *
 * companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 걸 추천
 *
 * kotiln에서 익명 클래스를 만들 때 object: 타입
 *
 */


fun main() {
    println(SingleTon.a)
    SingleTon.a += 10
    println(SingleTon.a)


    // 코틀린에서 익명클래스 사용법
    moveSomething(object : Movable{
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }

    })

}


class KotilnPerson(
    private val name: String,
    private val age: Int
) {
    companion object Factory : KLog{
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): JavaPerson {
            return JavaPerson(name, MIN_AGE)
        }

        override fun log() {
            println("companin object log")
        }
    }

}


interface KLog{
    fun log()
}


/**
 * 코틀린에서 싱글톤 구현
 * object 키워드 하나로 바로 싱글톤 구현가능
 */

object SingleTon{
    var a:Int = 0
}


private fun moveSomething(movable:Movable){
    movable.move()
    movable.fly()
}