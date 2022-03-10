package kt


/**
 * 코틀린에서도 자바 utill이 들고 있는 클래스를 사용가능,
 * 하지만 코틀린에서 제공하는 컬렉션을 사용해보자.
 * 차이점이라면 불변과 가변 컬렉션이 구분되어있음
 */



fun main(args: Array<String>){
    //가변 컬렉션
    val mutableList: MutableList<String> = mutableListOf("가", "나")
    //컬렉션 함수 get() set() add()
    mutableList.add("다")
    mutableList.set(0,"하")
    println("${mutableList[0]} ${mutableList[1]} ${mutableList[2]}")
    println("${mutableList.get(0)} ${mutableList.get(1)} ${mutableList.get(2)}")

    //불변 컬렉션 add()와 set()사용 불가능
    val list: List<String> = listOf("가", "나")
    println("${list.get(0)} ${list.get(1)}")

    //ArrayList를 사용하면 불변이다.
    val array: ArrayList<String> = arrayListOf("가", "나")
    array.add("다")
    println("${array.get(0)} ${array.get(1)} ${array.get(2)}")
}

