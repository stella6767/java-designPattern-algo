package javacore.basic.oop;

public class Truk implements Control{

    private Engine5000 engine5000;
    private NormalTier tier;

    @Override
    public void driving() {
        engine5000.start();
        System.out.println( this.tier + " 로 truk이 주행합니다.");
    }

    @Override
    public void stop() {
        System.out.println(" truk이 멈춘다.");
    }


}
