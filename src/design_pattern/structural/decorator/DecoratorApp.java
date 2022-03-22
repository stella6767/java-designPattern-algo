package design_pattern.structural.decorator;

import java.util.ArrayList;
import java.util.Collections;

public class DecoratorApp {

    /**
     * 기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴
     * 
     * 상속을 통하면 유연하게 만들기가 어려우니 위임을 통해서..
     * 동적(런타임)으로 책임 추가.
     *
     * 장점 조합을 활용 - 새로운 클래스를 만들지 않고 SRP를 지키면서 기존 기능을 조합.
     *
     */

    private static boolean enabledLane = true;

    private static boolean enabledTraffic = true;



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


        //교차로를 표시하는 추가 기능을 지원하면서 기존의 다른 추가 기능(차선 표시와 교통량 표시)과의 조합을 지원
        Display roadWithLaneAndTraffic =
                new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLaneAndTraffic.draw();


        //자바에서의 사용예시 , Collections API의 checked
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new RoadDisplay()); //아무거나 넣을 수 있지만,
        Collections.checkedList(arrayList, LaneDecorator.class); //타입을 정함
        //Collections.synchronizedList() //동기화
        //Collections.unmodifiableList() //불변화

        //스프링에서의 사용예시, ServerHttpRequestDecorator,

    }

}
