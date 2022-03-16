package javacore;

import kotlin.jvm.internal.Lambda;

interface B {
    void hello();
}



public class Func {
    B b;
    int num=10;

    static void printData(int a, int b)  {

        if(a == b){
            return;
        }else{
            System.out.println("Hellog World!!");
        }


        printData(a, b+1);
    }

    public static void main(String[] args) {

        //printData(3, 1);

        Func f = new Func();
        f.a();
        f.k();

//        int number = 10;
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                //자바 8 이후 javac가 final 자동 추가?
////                자바는 메서드내의 지역변수에 대한 스레드안정성을 보장합니다. 지역변수를 내부 익명객체가 바꿀수있게(자바스크립트처럼) 만들어버리면 메서드내에서 스레드를 추가로 생성해서 지역변수의 값을 바꿀수도있게됩니다.
////  그럼 결국 지역변수가 스레드안정성을 보장하지못하게되지요.
////
////                그래서 인스턴스필드는 내부객체에서도 변경할 수 있지만 지역변수는 내부객체에서는 변경하지 못하게 만들었습니다
//                System.out.println(number);
//            }
//        };

        //runnable.run();
        //System.out.println(number);



    }

    public void a() {

        int num =20;

        b = new B(){
           // int num = 111;
            @Override
            public void hello() {

                System.out.println(num);
            }
        };
        System.out.println("a close");

        /**
         * num은 a의 스택(지역변수) 이니까, a가 종료되면 함수 a의 num은 없어질 거라고 생각한다.
         *. 대신 컴파일러는 다른 익명클래스에서 이 변수를 참조하였을 경우, 래퍼런스 자체를 기억하는 게 아니라,
         * 새로운 공간에서(가짜 스택공간)을 만들어 readonly(읽기 전용)으로 저장한다. 그래서 변경이 불가능한 것이다.
         * 따라서 어차피 변경이 불가능하니, 익명클래스에서 스택 변수를 사용할 시, 원칙적으로 그 변수를 final로 붙여주는
         *
         * 익명클래스에서 스택의 변수를 참조하고 있다면, 스택이 안 날라감.( 환경을 기억)
         * 래퍼런스 자체를 기억하는 게 아니라, 새로운 공간에서.(가짜 스택공간)을 만들어 readonly(읽기 전용)으로 기억. 실제 스택변수는 날라감. 그래서 변경할 수 없음..
         * 자바스크립트에서는 이런 개념을  호이스팅. 클로저라고 한다. 클로저 = 영역이 확장돼서 스코프가 감싸짐. 람다식일 경우
         */
    }

    public void k(){
        b.hello();
    }


}
