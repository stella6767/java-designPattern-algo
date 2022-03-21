package design.decorator;

public class DisplayDecorator implements Display{

    /**
     * 다양한 추가 기능에 대한 공통 클래스, Decorator
     */

    private RoadDisplay roadDisplay;

    public DisplayDecorator(RoadDisplay display) {
        this.roadDisplay = display;
    }

    @Override
    public void draw() {
        roadDisplay.draw();
    }



}
