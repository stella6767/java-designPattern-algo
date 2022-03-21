package design.decorator;

public class DecoratorApp {

    /**
     * 동적으로 책임 추가.
     * 객체의 결합을 통해서..
     *
     *
     *
     */


    public static void main(String[] args) {

        RoadDisplay road = new RoadDisplay();
        road.draw();

//        RoadDisplay roadWithLane = new DisplayDecorator();
//        //상속을 통한 기능의 확장은 각 기능별로 클래스를 추가해야 한다는 단점
//        roadWithLane.draw();


        Display laneDecorator = new LaneDecorator(new RoadDisplay());
        Display trafficDecorator = new TrafficDecorator(new RoadDisplay());

        laneDecorator.draw();
        trafficDecorator.draw();

    }

}
