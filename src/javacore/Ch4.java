package javacore;

public class Ch4 {

    //String class

    /**
     * https://tecoble.techcourse.co.kr/post/2020-07-29-equals-and-hashCode/
     *
     * 자바의 String 클래스 영역을 살펴보기 전에 해시함수란 무엇인가 부터 살펴보자.
     * 해시함수는 언제나 고정된 길이의 해시값으로 변환
     * 모든 경우의 수를 고정길이로 바꾸기 때문에 언젠가 서로 다른 데이터의 해시값이 일치하는 경우가 생길 수 있음. 이를 해시 충돌이라함.
     * 해시의 가장 큰 특징으로는 복호화가 안됨
     * 자바에서도 이런 해시코드를 보여주는 함수가 있는 모든 클래스의 조상인, Object 클래스가 들고 있음
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
     * 한정된 자원으로 최대한의 성능을 끌어내야 하는,
     *
     */



    public static void main(String[] args) {
        String str = "홍길동";
        System.out.println(str.hashCode());

        String str2 = "홍길동";
        System.out.println(str.hashCode());

        str = "임꺽정";
        System.out.println(str.hashCode());
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


