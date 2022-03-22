package design_pattern.structural.decorator;

public interface Display {

    /**
     * Component
     * 기본 기능을 뜻하는 ConcreateDecorator와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의
     * 클라이언트는 component를 통해 실제 객체를 사용.
     *
     */
    
    void draw();
}
