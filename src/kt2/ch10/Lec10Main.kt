package kt2.ch10

/**
 * Java, Kotiln 모두 추상클래스, 인터페이스 인스턴스화 불가
 * 추상 프로퍼티가 아니라면 상속받을 떄 open을 붙여줘야 함.
 *
 * 코틀린에서는 인터페이스의 default method는 생략가능.
 *
 * 상속 또는 구현을 할 시 : 을 사용해야한다.
 * 상위 클래스 상속을 구현할 때 생성자를 반드시 호출해야 한다.
 * override를 필수로 붙여줘야 한다.
 * 추상 맴버가 아니면 오버라이딩 할때 open을 붙여줘야 한다.
 *
 * 상속시 유의점: 코틀린은 class 생성 시 final을 자동으로 붙여주기 때문에
 * 일반 클래스를 상속받을 때, open으로 열어줘여 한다.
 *
 * 코틀린에서 정말정말 맘에 안 드는 점은  kotlin 에서는 인터페이스, 어노테이션 클래스,
 * enum, var 변수, 파라미터, mutable 프로퍼티를 제외하면 모두 기본이 final로 설정된다.
 * 즉 method도 default final. 여기서 JPA를 사용하면, 내부적으로 Lazy loading을
 * 하기 위해 Entity class를 상속하는 proxy class를 만들어서 사용하는데, 코틀린에서 class 기본이
 * Final이라 상속받기 위해선 open을 붙여줘야 한다. 조금 편리하게 하기 위해선, JPA 관련 어노테이션이
 * 붙은 클래스를 open으로 만들어주는 allOpen gradle plugin을 사용하면 되는데,
 * 이 플러그인은 모든 프로퍼티와 메서드를 open 으로 만든다. 근데 private set 은 final 메서드에서만 쓸 수 있다,
 * .... 차선책은 protected set.. 아마도 이펙티브 자바에서 변경가능성을 최소화하라는 아이템을
 * 언어적 차원에서 적극적으로 도입한 거 같아보이지만..
 * 그 외에도 하이버네이트와 같이 쓸 시, 자잘한 문제가 좀 있어보이는 것 같다..
 *
 */

fun main() {
    val base = Base()

}


abstract class KotilnAnimal(
    protected val species: String,
    protected open val legCount: Int
) {

    abstract fun move()
}


class KotilnCat(
    species: String
) : KotilnAnimal(species, 4) {

    override fun move() {
        println("cat move")
    }

}


class KotilnPenguin(
    private val wingCount: Int = 2,
    species: String
) : KotilnAnimal(species, 2), KotilnFlyable, KotilnSwimable {


    override fun move() {
        println("penguin move")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<KotilnFlyable>.act()
        super<KotilnSwimable>.act()
    }

    override fun fly() {
        TODO("Not yet implemented")
    }


    override val swingAbility: Int
        get() = 3
}

interface KotilnSwimable {

    val swingAbility: Int

    fun act() {
        println("어푸 어푸")
    }


}

interface KotilnFlyable {

    fun act() {
        println("파닥 파닥")
    }

    fun fly()
}


class Derived(
    override val number: Int
) : Base(number) {


    init {
        println("Deriverd class")
    }
}


 open class Base(
    open val number: Int = 100
) {

//     open var state:String = ""
//         private set

     var state:String = ""
         private set

     init {
        //상위 클래스의 init 블록이 먼저 실행되고,
        //number에는 이상한 값이 찍힌다.
        //하위클래스의 number를 get하는데, 하위클래스는 값이 아직 초기화되지 않았으므로
        //그래서 상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는
        //open을 피해야 함.
        println("Base Class")
        println(number)//Accessing non-final property number in constructor

    }

}
