package kt2.ch8

/**
 * public은 생략가능, 기본이 public
 *
 * 함수가 하나의 결과값이면 block 대신 = 사용가능
 * = 을 사용하는 경우 반환타입 생략가능
 *
 * default paramter 지원, named argument 지원
 *
 * 가변인자
 *
 * */

fun main() {

    repeat("Hello World", useNewLine = false)

    val array = arrayOf("A", "B", "C")
    printAll(*array)

}

fun max(a: Int, b: Int) = if (a > b) a else b


fun repeat(str: String?,
           num : Int = 3,
           useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

fun printAll(vararg strings: String?) {
    for (string in strings) {
        println(string)
    }
}


