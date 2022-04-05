package javacore.basic;

import java.util.ArrayList;

public class Ch3 {


    /**
     * Native Method Stack : 순수하게 JAVA로 구성된 코드만을 사용할 수 없는 시스템 자원이나 API가 존재.
     *
     * JVM 메모리 공간을 논리적으로 3가지 요소로 나뉘어요.
     *
     * Method area(static area) - Runtime constant pool 과 static 변수, 메서드 정보, class 정보.
     * 맴버변수 이름. 데이터 타입, 접근 제어자 정보, type 속성 등이 관리.
     * 프로세스가 시작이 되면 제일 먼저 메모리에 로드된다. 프로세스 종료될 때까지 유지.
     * JVM 당 하나만 생성. 모든 스레드들이 공유. 전역. 그 말은 static data는 중복 X, 한번밖에 못 만듬.
     * 프로세스 시작 전에 꼭 필요한 재료들을 탑재.
     *
     * Stack Area: 지역변수, 프로세스 실행과정에서 림시로 할당되었다가 해제되는 거, 파라미터, 임시 연산시 값등을 관리
     * { 가 시작이 되면 } 만나면 메모리 해제. 각 Thread 별로 따로 할당. 함수가 호출되면 생기는 영역
     * stack(LIFO)- frame이 단위를 추가(push). method가 마무리되면 결과반환하면서 pop됩니다.
     * 영역이 꽉 차면, stackoverflowError
     *
     * Heap area : cpu가 엄격하게 관리하지 않는 메모리 영역. new 키워드로 할당. JVM당 하나만 생성.
     * 모든 스레드가 참조가능. 전역. java로 구성된 객체 및 String pool ..등이 탑재
     * 가비지 컬렉션의 대상. Heap 메모리 영역이 가득차면 OutOFMemoryError 방생.
     *
     *
     *
     * @param args
     */



    public static void main(String[] args) {

//        System.out.println("JVM 메모리 구조");
//
//        new ArrayList(Integer.MAX_VALUE);


        System.out.println(Zealot.attack);

        Zealot zelot1 = new Zealot("zelot1");
        Zealot zelot2 = new Zealot("zelot2");
        Zealot zelot3 = new Zealot("zelot3");

        System.out.println(zelot1.name);

        zelot1.hp = 100;

        zelot1.attack = 20;

        System.out.println(zelot1.attack); //100
        System.out.println(zelot2.attack);
        System.out.println(zelot3.attack);












//        Zealot z = new Zealot("Zealot1"); //스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는 셈
//        Zealot z1 = new Zealot("Zealot2"); //스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는 셈
//        Zealot z2 = new Zealot("Zealot3"); //스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는 셈
//
//
//        z.hp = 10;
//        z.attack = 30; //하나의 공간에 값만 바뀜. 새로 메모리가 생겨난 게 아니에요.
//
//        printZealot(z);
//        printZealot(z1);
//        printZealot(z2);

//        Ch3 ch3 = new Ch3();
//
//        ch3.a();
//
//
//        if (true){
//            int a = 10;
//        }
//
        int a = 10;
//        System.out.println(a);

//        try {
//
//            stackOverFlow(0);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

    private static void printZealot(Zealot z) {
        System.out.println(z.name);
        System.out.println(z.hp);
        System.out.println(z.attack);
        System.out.println("==========================");

    }


    static int stackOverFlow(int num){
         num = num + 1;
        System.out.println("num => " + num);
         return stackOverFlow(num);
    }

    public void a(){
        int i = 10;
    }

}


class Zealot {
    final String name;
    int hp; //4byte
    static int attack = 10; // 4byte

    Zealot(String name) {
        this.name = name;
    }
}
