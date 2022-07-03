package kt2.ch19

import kt2.ch1.Person
import kt2.ch14.KotilnPersonDto

/**
 *  scope function : 일시적인 영역을 형성하는 함수
 *
 *  //람다의 결과를 반환,
 *  1.let, it 사용
 *  2.run, this 사용
 *  //객체 그 자체를 반환,
 *  3.also, it 사용
 *  4.apply, this 사용
 *  //with는 확장함수가 아님.
 *  5.with
 */





fun printPerson(person: Person){

    person?.let {
        println(it.name)
        println(it.age)
    }

    val kotilnPersonDto = with(person) {
        println(name) //this는 생략가능
        println(this?.age)

        KotilnPersonDto(
            name = name,
            age = age
        )
    }



//    if (person!= null){
//        println(person.name)
//        println(person.age)
//    }
}

/**
 * 제네릭
 * 리플렉션
 * 복잡한 FP
 * DSL
 * 동시성 프로그래밍(코루틴)
 *
 * 은 다음 기회로..
 */

