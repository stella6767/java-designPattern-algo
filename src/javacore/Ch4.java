package javacore;

import org.openjdk.jol.vm.VM;

public class Ch4 {

    //String class

    /**
     *
     * https://www.baeldung.com/java-object-memory-address
     *
     * https://woo-dev.tistory.com/43
     * 자바는 call by reference 가 없나?
     * C++에는 포인터(Pointer)와 레퍼런스(Reference)라는 개념이 있다.
     * 포인터는 변수의 주소를 저장하는 특별한 타입의 변수, 포인터 사용 시(call by address)
     * 배열이나 객체를 넘길 때 주소가 넘어가니 call-by-reference라고 착각하기 쉽지만
     * call-by-value where the value is reference" 라고 이해해야 한다
     * 반면 참조자 ref는 포인터처럼 변수 개념으로 따로 생성되는 것이 아니다.
     *
     *  call by address의 정체는 call by value,  call by address가 주소를 넘겨주는 것 처럼 보이지만 사실 call by value 방식처럼 단순히 주소를 복사해서 주소라는 '값'을 메모리에 임시로 저장 후 인자로 넘기기 때문
     *
     * 해시함수는 언제나 고정된 길이의 해시값으로 변환
     * 모든 경우의 수를 고정길이로 바꾸기 때문에 언젠가 서로 다른 데이터의 해시값이 일치하는 경우가 생길 수 있음. 이를 해시 충돌이라함.
     * 해시의 가장 큰 특징으로는 복호화가 안됨
     * 자바에서도 이런 해시코드를 보여주는 함수가 있는 모든 클래스의 조상인, Object 클래스가 들고 있음
     *
     *
     * https://www.baeldung.com/java-object-memory-address
     * 자바는 메모리 주소 확인,  이것은 메모리 주소 가 아닙니다 . 이것은 단지 해시 코드
     * , hashCode는 단순히 고유한 개체에 고유한 정수를 반환을 하지, 메모리주소로 무조건 구현되지는 않는다는 말이다.
     *  해시코드는 실제메모리 주소가 아니라 지정된 위치에서 객체를 가져오기 위한 JVM의 링크
     * 종종 개체의 초기 메모리 주소이지만 시간이 지남에 따라 VM에 의해 개체가 메모리에서 이동할 수 있습니다. 그래서 (간단히) 아무것도 믿을 수 없습니다.
     * 변수의 메모리 주소를 가져오는 것은 Java 내에서 의미가 없습니다. JVM은 자유롭게 개체를 구현하고 적절하다고 생각되는 대로 이동할 수 있기 때문입니다(가비지 수집 등 동안 개체가 이동할 수 있음/움직일 수 있음).
     *
     *
     *
     * https://tecoble.techcourse.co.kr/post/2020-07-29-equals-and-hashCode/
     *
     * 자바의 String 클래스 영역을 살펴보기 전에 해시함수란 무엇인가 부터 살펴보자.

     * String은 래퍼런스 자료형이고 해시코드는 주소를 가지고 해시값으로 변경해준다.  그렇다면 str과 str2가 같은 메모리 주소를 가지는 것일까? 답은 그렇다!
     *
     *
     * 먼저 String 클래스에 값을 할당하는 방법 2가지가 있음을 살펴보자.
     * 첫번째는 String literal, 즉 큰 따옴표("")를 사용하는 것이고,
     * 두번째는 new 연산자를 사용하는 것이다
     *
     * new 연산자로 String 객체를 생성하지 않는 것이 좋다.  String은 좀 특이
     * String literal로 생성하면 해당 String 값은 Heap 영역 내 "String Constant Pool"에 저장되어 재사용되지만, new 연산자로 생성하면 같은 내용이라도 여러 개의 객체가 각각 Heap 영역을 차지하기 때문
     *
     * String literal로 생성한 객체는 "String Pool"에 들어간다. String literal로 생성한 객체의 값(ex. "Cat")이 이미 String Pool에 존재한다면, 해당 객체는 String Pool의 reference를 참조
     * new 연산자로 생성한 String 객체는 같은 값이 String Pool에 이미 존재하더라도, Heap 영역 내 별도의 객체를 가리키게 된다.
     *\같은 주소지를 공유한 str1과 str2 중 str2의 값을 변경하면 자동으로 str2를 새로운 메모리 주소에 할당하므로, 같은 주소를 쓰므로 str1도 변경됐을지 모른다는 불안감에 안 떨어도 된다.
     *
     *
     * 포인터가 없음으로 한계
     * oop,공감 90, 비공감 10, c는 메모리  엑세스에 대한 자유도가 높음... 그만큼 신경써줘야 될게 많음
     * C로도 구조체를 이용해서 충분히 객체지향적인 설계 가능, 절차지향과 반대의 개념이 아님.
     * 한정된 자원으로 최대한의 성능을 끌어내야 하는, 사물인터넷, 시스템, 게임엔진. 같은 것에서 그렇게 쓰기 좋은 언어가 없음.
     * 하이레벨이란 좀 더 기게에 가까운, 기계에게 더 많은 조작과 자유를 허용할 수 있는 자유도가  높은, c++ 에 비해서 개발쟈가 신경쓸 요소가 적음.
     *
     *
     *
     */



    public static void main(String[] args) {
//        String str = "홍길동";
//        System.out.println(str.hashCode());
//
//        String str2 = "홍길동";
//        System.out.println(str.hashCode());
//
//        str = "임꺽정";
//        System.out.println(str.hashCode());
//
        String answer = "42";
        int a = 10;

        System.out.println("The memory address is " + VM.current().addressOf(answer));
        System.out.println("The memory address is " + VM.current().addressOf(a));

/*        런타임 데이터 영역의 메모리 레이아웃은 JVM 사양의 일부가 아니며 구현자의 재량에 맡긴다는 점을 언급할 가치가 있습니다.
        따라서 각 JVM 구현은 메모리에 객체와 배열을 배치하는 다른 전략을 가질 수 있습니다. 이것은 차례로 메모리 주소에 영향을 미칩니다.
        대부분의 JVM 구현에서 메모리 주소는 GC가 때때로 개체를 이동함에 따라 변경될 수 있습니다.*/

    }


    static class MyData  {
        int a =1; //4byte
        byte b; // 1byte
    }

    static void callByValue(int a){
        a++;

    }

    static void callByReference(Ch2.MyData myData){
        //주소값을 직접 넘기는 게 아니라. 주소값을 복사해서 넘기기 때문에, call by value라고 봐야함.
        //C++에서는 메모리 주소를 개발자가 직접적으로 다룰 수 있지만..
        myData.a ++;
    }

    static void callByReference2(String s){
        //주소값을 직접 넘기는 게 아니라. 주소값을 복사해서 넘기기 때문에, call by value라고 봐야함.
        //C++에서는 메모리 주소를 개발자가 직접적으로 다룰 수 있지만..
        s = "test";
    }


}


