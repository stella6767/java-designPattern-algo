package kt2.ch13

/**
 * 코틀린에서 중첩 클래스는 기본적으로 static class
 *
 * 권장되지 않는 형태의 중첩 클래스를 사용할려면 inner 키워드dhk
 * 바깥클래스 참조를 위해 this@바깥클래스 형태
 */


fun main() {

}

class KotilnHouse(
    private val address: String,
    //val livingRoom: LivingRoom = LivingRoom(10.0)
    val livingRoom: LivingRoom

) {
    //class LivingRoom(private val area: Double)
    inner class LivingRoom(private val area: Double){
        val address:String
            get() = this@KotilnHouse.address
    }
}
