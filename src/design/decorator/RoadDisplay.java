package design.decorator;

public class RoadDisplay implements Display {

    /**
     * 기본 도로 표시 클래스, ConcreateComponent
     */

    @Override
    public void draw(){
        System.out.println("기본 도로 표시");
    }
    
}
