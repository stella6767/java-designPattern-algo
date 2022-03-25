package javacore.basic.oop;

public class Genesis extends Car implements Control {

    private Engine5000 engine5000;
    private Tier tier;

    public Genesis(Tier tier) {
        this.tier = tier;
    }

    @Override
    public void driving() {
        System.out.println(this.tier + " 로 제네시스가 굴러갑니다.");
    }

    @Override
    public void stop() {

    }
}
