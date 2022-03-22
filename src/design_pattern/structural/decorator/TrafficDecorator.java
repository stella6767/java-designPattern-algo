package design_pattern.structural.decorator;

public class TrafficDecorator extends DisplayDecorator{
    public TrafficDecorator(Display display) {
        super(display);
    }



    @Override
    public void draw() {
        super.draw();
        drawTraffic();
    }

    private void drawTraffic() {

        System.out.println("\t교통량 표시");
    }

}
