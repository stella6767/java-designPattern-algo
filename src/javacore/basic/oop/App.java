package javacore.basic.oop;

public class App {

    /**
     * 강제성을 가짐. 추상메서드를 정의하면, 절대적으로 똑같은 이름으로 구현시켜야 하기 때문에, 실수의 여지를 줄일 수 있어요.
     * 다형성을 구현하면서, 관계없는 클래스들을 묶는 역할을 할 수 있잖아요.
     *
     * SOLID,
     *
     * SRP,
     *
     * 쓸데없는 인터페이스,
     * 의존관계를 최대한 없애는 쪽, 클래스 설계를 최대한 단순화시켜서 작업.
     *
     * 
     *
     */


    public static void main(String[] args) {

        Control sonata = new CarFactory().control();

        Ferari ferari = new Ferari();
        ferari.질주();

        start(sonata);

    }


    static void start(Control c){
        c.driving();
        c.stop();
    }


}
