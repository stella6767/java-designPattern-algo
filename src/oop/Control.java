package oop;

public interface Control {

    //인터페이스 정의: 약속을 만드는 갑
//자동차 엑셀
//인터페이스는 new 할 수 없다. 왜냐면 추상메소드를 가졌기 때문!!!
//자식을 new 하면 같이 뜸

    void 엑셀();
    void 브레이크();
    default void 질주2(){
        System.out.println("디폴트 메서드로 질주");
    }

}
