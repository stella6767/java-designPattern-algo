package javacore;

import java.util.LinkedList;
import java.util.List;

public class Ch3 {

    /**
     * java만의 특징, 모든 코드는 class 내부에 둬야 합니다.
     *
     * native method stack: 순수하게 JAVA로 구성된 코드만을 사용할 수 없는 시스템 자원이나 api 가 존재.
     *
     * Method area(스태틱 영역): Runtime constant pool 과 static 변수, 메서드정보, class 정보를 관리
     * JVM당 하나만 생성, 모든 스레드들이 공유, 전역
     * static 은 main frame이 열리기 전에 메모리에 로드. 그 말이 static data는 중복될 수 없음
     * 두개가 메모리에 못 뜸 -> static 데이터는 공유될 수 있는 데이터,
     * 프로세스 시작부터 -> 끝까지 유지. 용량이 크면 부하가 큼.
     *
     * Stack area: 각 Thread 별로 따로 할당. 각 Thread들은 메서드를 호출할 때마다 Frame이라는 단위를 추가(push)
     * 지역변수.
     *
     * heap: java 로 구성된 객체 및 jre 클래스들이, String pool 탑재, 자동으로 관리되지 않고, CPU가 엄격하게 관리하지 않는 컴퓨터 메모리 영역
     * JVM 당 하나 생성. 모든 스레드가 참조가능. heap은 new 할 때 메모리에 뜸. 타이밍이 무조건 static보다 늦음.
     * 가바지 콜렉션의 대상.
     *
     *
     */



    //.class 실행하면 static 부분이나, class 정보를 메모리에 로드,
    // static area 공간에 있는 main() 함수를 찾아서 호출합니다.
    public static void main(String[] args) {

//        int i;
//
//        try {
//
//            int num = func(0);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        normal();

        Zealot z =  new Zealot("zealot1"); // 스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는거
        Zealot z2 =  new Zealot("zealot2"); // 스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는거
        Zealot z3 =  new Zealot("zealot3"); // 스택 영역에 생성된 z가 힙 영역에 생성된 Zealot 인스턴스를 가리키고 있는거

        z.hp = 10;

        z.attack --;

        System.out.println(z.attack);
        System.out.println(z2.attack);
        System.out.println(z3.attack);
    }

    
    static int func(int num){
        num = num + 1;
        return func(num);
    }


    static void normal(){
        int a;

        System.out.println("normal");
    }


}


class Zealot {

    final String NAME;
    int hp; //Zealot.hp
    static int attack = 10;

    Zealot(String name) {
        this.NAME = name;
    }


}