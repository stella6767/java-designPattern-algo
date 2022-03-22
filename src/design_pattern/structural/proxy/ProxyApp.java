package design_pattern.structural.proxy;

public class ProxyApp {

    /**
     * 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴. 진짜 서브젝트 클래스를 감싸고 있는 대리 객체를 만들어서 부가기능을 실행.
     * 일단은 인터페이스 기반의 프록시 패턴.
     *
     * cglib,bytebuddy 또는 리플렉션을 사용한 동적인(다이나믹) 프록시 객체 생성은 이미 다뤘으니 생략..
     *
     * 사용예시 - spring AOP ( 선언적 Transactional,.. 선언적 Cacheable... )
     *
     */


    public static void main(String[] args) {

        GateService gateService = new DefaultGateServiceProxy();

        gateService.openGate();
    }

}
