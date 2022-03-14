package oop;

public class Ferari extends Vehicle implements Control,질주 {
    private String name;
    private Engine5000 engine5000;
    @Override
    public void 엑셀() {
        System.out.println("전진");

    }
    @Override
    public void 브레이크() {
        System.out.println("멈춤");

    }
    @Override
    public void 질주() {
        System.out.println("나만 질주가 가능하다");

    }

}