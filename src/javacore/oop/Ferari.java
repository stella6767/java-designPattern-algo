package javacore.oop;

public class Ferari extends Car implements Control, 질주{

    private Engine5000 engine5000; //컴포지션,
    private NormalTier tier;

    @Override
    public void driving() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void 질주() {
        System.out.println("질주!!!");
    }
}
