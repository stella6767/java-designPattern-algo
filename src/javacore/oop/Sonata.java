package javacore.oop;

public class Sonata extends Car implements Control{

    private Engine2000 engine2000;
    private Tier tier; //의존적인 관꼐

    public Sonata(Tier tier) { //의존성 주입,
        this.engine2000 = new Engine2000();
        this.tier = tier;
    }


    @Override
    public void driving() {
        engine2000.start();
        System.out.println( this.tier + " 로 sonata가 주행합니다.");
    }

    @Override
    public void stop() {

    }

}
