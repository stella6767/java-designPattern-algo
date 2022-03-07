package kt


/**
 * kotiln의 배열은 Array 클래스로 표현됨. 배열을 생성하려면 함수를 사용(arrayof(), arrayOfNulls())
 *
 * kotiln의 배열은 불변임.
 *
 *
 *
 */



fun main(){



    var array = arrayOf(1, "kang", true)

    array[0] = 10 as Nothing

    println("${array[0]} .. ${array[1]} .. ${array[2]} .. ${array.get(0)}")
    println("size : ${array.size} .. ")

    var array2 = arrayOf<Int>(1,2)
    println("${array2[0]} .. ${array2[1]}")


    val x: IntArray = intArrayOf(1, 2, 3)//Kotlin에는 boxing 오버헤드 없이 기본 유형의 배열을 나타내는 클래스도 있습니다 ByteArray, ShortArray, IntArray등)

//    var array3 = intArrayOf(3,4)
//    println("${array3[0]} .. ${array3[1]}")
//
//    //매개변수 x자리에는 ()가 필요 없다. 자바스크립트는 매개변수가 2개 이상이면 ()가 필요함.
//    //Array클래스는 첫번째 자리가 size이고 두번째 자리가 함수이다.
//    var array4 = Array(4, fun(x) : Int { return x*10})
//    println("${array4[0]} .. ${array4[1]} .. ${array4[2]} .. ${array4[3]} .. ")
//
//    var array5 = Array(4, {x -> x * 10})
//    println("${array5[0]} .. ${array5[1]} .. ${array5[2]} .. ${array5[3]} .. ")
//
//    //초기값이 없는 배열 만들기 (배열의 사이즈는 명시해줘야 함)
//    var array6 = arrayOfNulls<Int>(2)
//    array6[0] = 10
//    array6[1] = 20
//
//    println("${array6[0]} .. ${array6[1]}")
}

