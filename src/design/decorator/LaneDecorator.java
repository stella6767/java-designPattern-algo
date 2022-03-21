package design.decorator;

public class LaneDecorator extends DisplayDecorator{

    /**
     * 차선 표시를 추가하는 클래스 (ConcreateDecoratorA)
     * Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함
     * @param display
     */
    
    public LaneDecorator(RoadDisplay display) {
        super(display);
    }

    @Override
    public void draw() {
        super.draw();
        drawLane();
    }

    private void drawLane() { System.out.println("\t차선 표시"); }
}
