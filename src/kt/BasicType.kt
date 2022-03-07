package kt


fun main() {

    val a: Byte = 127 //8비트
    val b: Short = 127
    val c: Int = 127
    val d: Long = 127L
    val e: Float = 3.14f
    val f: Double = 32.222222
    val g: Boolean = true
    val g2 = false //데이터 타입 생략 가능, 추론

    val  h = 'A' //Char
    val  h2 : Char = 'A' //Char
    val str : String = "ABC"

    println("a= ${a} ${a.javaClass} ${Byte.MIN_VALUE} ~ ${Byte.MAX_VALUE}  ")
    println("a= ${b} ${b.javaClass}")
    println("a= ${c} ${c.javaClass}")
    println("a= ${d} ${d.javaClass}")
    println("a= ${e} ${e.javaClass}")



}